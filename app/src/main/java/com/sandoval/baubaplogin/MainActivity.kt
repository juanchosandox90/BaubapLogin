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
import com.sandoval.baubaplogin.ui.screens.login.LoginScreen
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
        LoginScreen()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaubapLoginTheme {
        BaubaApp()
    }
}