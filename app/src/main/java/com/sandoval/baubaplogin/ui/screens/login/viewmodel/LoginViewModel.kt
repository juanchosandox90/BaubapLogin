package com.sandoval.baubaplogin.ui.screens.login.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sandoval.baubaplogin.ui.common.state.ErrorState
import com.sandoval.baubaplogin.ui.screens.login.state.LoginErrorState
import com.sandoval.baubaplogin.ui.screens.login.state.LoginState
import com.sandoval.baubaplogin.ui.screens.login.state.LoginUiEvent
import com.sandoval.baubaplogin.ui.screens.login.utils.emailOrMobileEmptyErrorState
import com.sandoval.baubaplogin.ui.screens.login.utils.passwordEmptyErrorState

class LoginViewModel : ViewModel() {

    var loginState = mutableStateOf(LoginState())

    fun onUiEvent(loginUiEvent: LoginUiEvent) {

        when (loginUiEvent) {
            //Email/Mobile
            is LoginUiEvent.EmailOrMobileChanged -> {
                loginState.value = loginState.value.copy(
                    emailOrMobile = loginUiEvent.emailOrMobile,
                    errorState = loginState.value.errorState.copy(
                        emailOrMobileErrorState = if (loginUiEvent.emailOrMobile.trim()
                                .isNotEmpty()
                        ) ErrorState() else emailOrMobileEmptyErrorState
                    )
                )
            }

            //Password Changed
            is LoginUiEvent.PasswordChanged -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.password,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.password.trim()
                                .isNotEmpty()
                        ) ErrorState() else passwordEmptyErrorState
                    )
                )
            }

            //Submit login
            is LoginUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    loginState.value = loginState.value.copy(
                        isLoginSuccessful = true
                    )
                }
            }
        }
    }

    /**
     * Funcion que valida los inputs
     * @return true -> los inputs son validos
     * @return false -> los inputs no son validos
     */
    private fun validateInputs(): Boolean {
        val emailOrMobileString = loginState.value.emailOrMobile.trim()
        val passwordString = loginState.value.password

        return when {
            //Email/Mobile empty
            emailOrMobileString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        emailOrMobileErrorState = emailOrMobileEmptyErrorState
                    )
                )
                false
            }

            //Password empty
            passwordString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }

            // No errors
            else -> {
                // Default error state
                loginState.value =
                    loginState.value.copy(errorState = LoginErrorState())
                true
            }
        }
    }

}