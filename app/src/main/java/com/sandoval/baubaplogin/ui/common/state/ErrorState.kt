package com.sandoval.baubaplogin.ui.common.state

import androidx.annotation.StringRes
import com.sandoval.baubaplogin.R

data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessage: Int = R.string.empty_string,
)