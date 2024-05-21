package com.ezlohub.presentation.ui.allDevices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezlohub.R
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
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(state.devicesList) { item ->
            DeviceItem(
                imageRes = item.imageRes,
                title = item.name,
                subTitle = item.sn
            )
        }
    }
}


@Composable
fun DeviceItem(
    imageRes: Int,
    title: String,
    subTitle: String,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.errorContainer,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
                Text(text = title)
                Text(text = subTitle)
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
        color = MaterialTheme.colorScheme.onBackground // Adjust color and opacity
    )
}


@Preview
@Composable
private fun DeviceItemPreview() {
    EzloHubTheme {
        DeviceItem(
            R.drawable.john_wayne__portrait,
            "Home Number 1",
            "sn: 3443434334"
        )
    }
}

@Preview
@Composable
private fun AllDevicesScreenPreview() {
    EzloHubTheme {
        AllDevicesScreen(
            state = AllDevicesState(mockItems),
            onAction = {}
        )
    }
}

@Composable
fun DeviceDetails(deviceItem: DeviceInfo) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.errorContainer,
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = deviceItem.imageRes),
                    contentDescription = "device image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                )
                Text (modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = deviceItem.name)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = deviceItem.sn)
            Text(text = deviceItem.macAddress)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = deviceItem.firmware)
            Text(text = deviceItem.model)
        }
    }
}

@Preview
@Composable
private fun DetailsPreview() {
    EzloHubTheme {
        val device = DeviceInfo(
            R.drawable.john_wayne__portrait, "Name1",
            "sn: 2323232323",
            "mac adress 23232323",
            "firmware 30323003",
            "model 032030do230"
        )
        DeviceDetails(device)
    }
}


val mockItems = listOf(
    DeviceInfo(
        R.drawable.john_wayne__portrait, "Name1",
        "1",
        "",
        "",
        ""
    ),
    DeviceInfo(
        R.drawable.john_wayne__portrait, "Name2",
        "2",
        "",
        "",
        ""
    ),
    DeviceInfo(
        R.drawable.john_wayne__portrait, "Name3",
        "3",
        "",
        "",
        ""
    ),
    DeviceInfo(
        R.drawable.john_wayne__portrait, "Name4",
        "4",
        "",
        "",
        ""
    )
)