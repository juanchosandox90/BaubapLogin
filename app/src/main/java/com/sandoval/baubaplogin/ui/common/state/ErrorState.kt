package com.sandoval.baubaplogin.ui.common.state

data class ErrorState(
    val hasError: Boolean = false,
    val errorMessage: String = "",
)