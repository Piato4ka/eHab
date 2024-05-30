package com.ezlohub.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ezlohub.presentation.ui.NavigationRoot
import com.ezlohub.presentation.ui.allDevicesScreen.AllDevicesState
import com.ezlohub.presentation.ui.allDevicesScreen.AllDevicesViewModel
import com.ezlohub.presentation.ui.allDevicesScreen.UserInfo
import com.ezlohub.presentation.ui.theme.EzloHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AllDevicesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EzloHubTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: AllDevicesViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.secondary
    ) {
        val navController = rememberNavController()
        val state: AllDevicesState by viewModel.devicesState.collectAsState(
            initial = AllDevicesState(emptyList())
        )
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        titleContentColor = MaterialTheme.colorScheme.onBackground,
                    ),
                    title = {
                        Text("EzloHub")
                    }
                )
            },
        ) { innerPadding ->
            Column {
                UserInfo(
                    Modifier
                        .padding(innerPadding),
                    state
                )
                NavigationRoot(
                    navController = navController,
                    state
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    EzloHubTheme {
//        MainScreen(AllDevicesViewModel())
//    }
//}