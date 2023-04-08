package com.sandoval.baubaplogin.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.sandoval.baubaplogin.R
import com.sandoval.baubaplogin.ui.theme.AppTheme
import com.sandoval.baubaplogin.ui.theme.BaubapLoginTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {

    val keyboardController = LocalSoftwareKeyboardController.current

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

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
                //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                //Titulo de la pantalla
                Text(
                    text = "Bauba App",
                    modifier = Modifier
                        .padding(top = AppTheme.dimens.paddingLarge)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
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

                //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                //Login titulo
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge)
                )

                //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                //Caja de Inputs
                Column(modifier = Modifier.fillMaxWidth()) {
                    //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                    //Input Email
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = AppTheme.dimens.paddingLarge),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = "Email ID or Mobile Number"
                            )
                        },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )

                    //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                    //Input Password
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = AppTheme.dimens.paddingLarge),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = "Password"
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                isPasswordVisible = !isPasswordVisible
                            }) {
                                val visibleIconAndText = Pair(
                                    first = Icons.Outlined.Visibility,
                                    second = "Password Visible"
                                )

                                val hiddenIconAndText = Pair(
                                    first = Icons.Outlined.VisibilityOff,
                                    second = "Password Hidden"
                                )

                                val passwordVisibilityIconAndText =
                                    if (isPasswordVisible) visibleIconAndText else hiddenIconAndText

                                //Render Icon
                                Icon(
                                    imageVector = passwordVisibilityIconAndText.first,
                                    contentDescription = passwordVisibilityIconAndText.second
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                        })
                    )

                    //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                    //Forgot Password
                    Text(
                        modifier = Modifier
                            .padding(
                                top = AppTheme.dimens.paddingSmall
                            )
                            .align(alignment = Alignment.End)
                            .clickable {

                            },
                        text = "Forgot Password",
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    //TODO: Este componente se puede reutilizar, refactorizar a un composable reutilizable
                    // Login Button
                    Button(modifier = Modifier
                        .padding(top = AppTheme.dimens.paddingLarge)
                        .height(AppTheme.dimens.normalButtonHeight)
                        .requiredWidth(AppTheme.dimens.minButtonWidth),
                        onClick = { }) {
                        Text(
                            text = "Login",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
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
