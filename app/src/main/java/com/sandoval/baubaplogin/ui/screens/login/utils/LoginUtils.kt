package com.sandoval.baubaplogin.ui.screens.login.utils

import com.sandoval.baubaplogin.R
import com.sandoval.baubaplogin.ui.common.state.ErrorState


val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true, errorMessage = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true, errorMessage = R.string.login_error_msg_empty_password
)