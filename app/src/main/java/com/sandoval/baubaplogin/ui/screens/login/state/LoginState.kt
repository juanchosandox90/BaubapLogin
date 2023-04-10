package com.sandoval.baubaplogin.ui.screens.login.state

import com.sandoval.baubaplogin.ui.common.state.ErrorState

data class LoginState(
    val emailOrMobile: String = "",
    val password: String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful: Boolean = false,
)

data class LoginErrorState(
    val emailOrMobileErrorState: ErrorState = ErrorState(),
    val passwordErrorState: ErrorState = ErrorState(),
)