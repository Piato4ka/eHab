package com.ezlohub.presentation.ui.allDevices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.sp
import com.ezlohub.R
import com.ezlohub.domain.model.Device
import com.ezlohub.domain.model.DeviceInfo
import com.ezlohub.presentation.ui.theme.EzloHubTheme


@Composable
fun DeviceDetails(deviceItem: DeviceInfo) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondary,

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
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    text = deviceItem.name,
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = deviceItem.sn,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary)
            Text(text = deviceItem.macAddress,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = deviceItem.firmware,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary)
            Text(text = deviceItem.model,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondary)
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