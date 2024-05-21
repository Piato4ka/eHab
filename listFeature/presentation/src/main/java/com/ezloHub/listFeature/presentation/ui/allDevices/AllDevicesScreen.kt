package com.ezloHub.listFeature.presentation.ui.allDevices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezlohub.R
import com.ezlohub.presentation.ui.allDevices.AllDevicesAction
import com.ezlohub.presentation.ui.allDevices.AllDevicesState
import com.ezlohub.presentation.ui.allDevices.AllDevicesViewModel
import com.ezlohub.presentation.ui.theme.EzloHubTheme

@Composable
fun AllDevicesScreenRoot(
    onDeviceClick: () -> Unit,
    onDeviceLongClick: () -> Unit,
    onDeleteClicked: () -> Unit,
    onCancelClicked: () -> Unit,
    viewModel: AllDevicesViewModel
) {
    AllDevicesScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AllDevicesAction.OnCancelClicked -> onCancelClicked()
                AllDevicesAction.OnDeleteClicked -> onDeleteClicked()
                AllDevicesAction.OnDeviceClick -> onDeviceClick()
                AllDevicesAction.OnDeviceLongClick -> onDeviceLongClick()
            }
        }
    )
}

@Composable
fun AllDevicesScreen(
    state: AllDevicesState,
    onAction: (AllDevicesAction) -> Unit,
) {
    UserInfo()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfo() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
    ) { innerPadding ->
        Column {
            Surface(
                color = MaterialTheme.colorScheme.errorContainer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.john_wayne__portrait),
                        contentDescription = "user photo",
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "John Wayne")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


@Preview
@Composable
private fun AllDevicesScreenPreview() {
    EzloHubTheme {
        AllDevicesScreen(
            state = AllDevicesState(),
            onAction = {}
        )
    }
}