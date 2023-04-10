package com.sandoval.baubaplogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sandoval.baubaplogin.ui.screens.navigation.NavigationRoutes
import com.sandoval.baubaplogin.ui.screens.navigation.authenticatedGraph
import com.sandoval.baubaplogin.ui.screens.navigation.unauthenticatedGraph
import com.sandoval.baubaplogin.ui.theme.BaubapLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaubapLoginTheme {
                BaubaApp()
            }
        }
    }
}

@Composable
fun BaubaApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainBaubapAppNavHost()
    }
}

@Composable
fun MainBaubapAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.Unauthenticated.NavigationRoute.route
    ) {
        unauthenticatedGraph(navController = navController)
        authenticatedGraph(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaubapLoginTheme {
        BaubaApp()
    }
}