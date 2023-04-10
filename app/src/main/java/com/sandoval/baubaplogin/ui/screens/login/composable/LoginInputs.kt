package com.sandoval.baubaplogin.ui.screens.login.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.sandoval.baubaplogin.ui.common.customComposablesViews.EmailTextField
import com.sandoval.baubaplogin.ui.common.customComposablesViews.NormalButton
import com.sandoval.baubaplogin.ui.common.customComposablesViews.PasswordTextField
import com.sandoval.baubaplogin.ui.screens.login.state.LoginState
import com.sandoval.baubaplogin.ui.theme.AppTheme

@Composable
fun LoginInputs(
    loginState: LoginState,
    onEmailOrMobileChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSubmit: () -> Unit,
    onForgotPasswordClicked: () -> Unit,
) {
    //Login inputS section
    Column(modifier = Modifier.fillMaxWidth()) {
        //Input Email
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.emailOrMobile,
            onValueChange = onEmailOrMobileChanged,
            label = "Email ID or Mobile Number",
            isError = loginState.errorState.emailOrMobileErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.emailOrMobileErrorState.errorMessage)
        )


        //Input Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.password,
            onValueChange = onPasswordChanged,
            label = "Password",
            isError = loginState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.passwordErrorState.errorMessage),
            imeAction = ImeAction.Done
        )

        //Forgot Password
        Text(
            modifier = Modifier
                .padding(
                    top = AppTheme.dimens.paddingSmall
                )
                .align(alignment = Alignment.End)
                .clickable {
                    onForgotPasswordClicked.invoke()
                },
            text = "Forgot Password",
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium
        )

        // Login Button
        NormalButton(
            text = "Login",
            modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge),
            onClick = onSubmit
        )
    }
}