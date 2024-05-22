package com.ezlohub.presentation.ui.allDevices

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezlohub.R
import com.ezlohub.presentation.ui.theme.EzloHubTheme

@Composable
fun AllDevicesScreenRoot(
    onDeviceClick: (Int) -> Unit,
    viewModel: AllDevicesViewModel
) {
    val state: AllDevicesState by viewModel.devicesState.collectAsState(
        initial = AllDevicesState(emptyList())
    )

    AllDevicesScreen(
        state = state,
        onAction = onDeviceClick
    )
}


@Composable
fun AllDevicesScreen(
    state: AllDevicesState?,
    onAction: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        if (state != null) {
            itemsIndexed(state.devicesList) { index, item ->
                DeviceItem(
                    imageRes = item.imageRes,
                    title = item.name,
                    subTitle = item.sn,
                    onItemClick = {
                        onAction(index)
                    }
                )
            }
        }
    }
}


@Composable
fun DeviceItem(
    imageRes: Int,
    title: String,
    subTitle: String,
    onItemClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                )
                .clickable(onClick = onItemClick),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "device image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
            )

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subTitle,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Icon(
                painter = painterResource(R.drawable.baseline_keyboard_arrow_right_40),
                contentDescription = "Details icon"
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 1.dp),
        color = MaterialTheme.colorScheme.onPrimary // Adjust color and opacity
    )
}


@Preview
@Composable
private fun DeviceItemPreview() {
    EzloHubTheme {
        DeviceItem(
            R.drawable.john_wayne__portrait,
            "Home Number 1",
            "sn: 3443434334",
            {}
        )
    }
}

//@Preview
//@Composable
//private fun AllDevicesScreenPreview() {
//    EzloHubTheme {
//        AllDevicesScreen(
//            state = AllDevicesState(mockItems),
//            onAction = {}
//        )
//    }
//}
