package com.sandoval.baubaplogin.ui.screens.login.utils

import com.sandoval.baubaplogin.ui.common.state.ErrorState


val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true, errorMessage = "Please enter your email or mobile number"
)

val passwordEmptyErrorState = ErrorState(
    hasError = true, errorMessage = "Please enter your password"
)