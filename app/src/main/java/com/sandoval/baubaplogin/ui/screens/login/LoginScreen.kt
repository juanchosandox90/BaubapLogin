package com.sandoval.baubaplogin.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.sandoval.baubaplogin.R
import com.sandoval.baubaplogin.ui.common.customComposablesViews.*
import com.sandoval.baubaplogin.ui.screens.login.composable.LoginInputs
import com.sandoval.baubaplogin.ui.theme.AppTheme
import com.sandoval.baubaplogin.ui.theme.BaubapLoginTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(
                rememberScrollState()
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.paddingLarge)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = AppTheme.dimens.paddingLarge)
                    .padding(bottom = AppTheme.dimens.paddingExtraLarge)
            ) {

                //Titulo de la pantalla
                MediumTitleText(
                    modifier = Modifier
                        .padding(top = AppTheme.dimens.paddingLarge)
                        .fillMaxWidth(),
                    text = "Bauba App",
                    textAlign = TextAlign.Center
                )

                //Logo del App en la Pantalla de Login
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .padding(top = AppTheme.dimens.paddingSmall),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data = R.drawable.baubap_logo)
                        .crossfade(enable = true).scale(Scale.FILL).build(),
                    contentDescription = "Logo de Baubap"
                )

                //Login titulo
                TitleText(
                    modifier = Modifier.padding(
                        top = AppTheme.dimens.paddingLarge
                    ), text = "Login"
                )

                //Caja de Inputs
                LoginInputs()
            }
        }

        Row(
            modifier = Modifier.padding(top = AppTheme.dimens.paddingNormal),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Don't have an account?
            Text(
                text = "Don't have an account?"
            )

            //Register
            Text(
                modifier = Modifier
                    .padding(start = AppTheme.dimens.paddingExtraSmall)
                    .clickable {

                    },
                text = "Register",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    BaubapLoginTheme {
        LoginScreen()
    }
}
