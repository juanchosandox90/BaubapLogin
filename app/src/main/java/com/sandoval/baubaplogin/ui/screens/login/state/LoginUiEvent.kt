package com.sandoval.baubaplogin.ui.screens.login.state

sealed class LoginUiEvent {
    data class EmailOrMobileChanged(val emailOrMobile: String) : LoginUiEvent()
    data class PasswordChanged(val password: String) : LoginUiEvent()
    object Submit : LoginUiEvent()
}
