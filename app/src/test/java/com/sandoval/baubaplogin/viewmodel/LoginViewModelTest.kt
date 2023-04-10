package com.sandoval.baubaplogin.viewmodel

import com.sandoval.baubaplogin.ui.common.state.ErrorState
import com.sandoval.baubaplogin.ui.screens.login.state.LoginErrorState
import com.sandoval.baubaplogin.ui.screens.login.state.LoginUiEvent
import com.sandoval.baubaplogin.ui.screens.login.utils.emailOrMobileEmptyErrorState
import com.sandoval.baubaplogin.ui.screens.login.utils.passwordEmptyErrorState
import com.sandoval.baubaplogin.ui.screens.login.viewmodel.LoginViewModel
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel()
    }

    @Test
    fun testEmailOrMobileChanged() {
        val newEmailOrMobile = "test@example.com"
        viewModel.onUiEvent(LoginUiEvent.EmailOrMobileChanged(newEmailOrMobile))

        TestCase.assertEquals(
            newEmailOrMobile,
            viewModel.loginState.value.emailOrMobile
        )
        assertEquals(ErrorState(), viewModel.loginState.value.errorState.emailOrMobileErrorState)
    }

    @Test
    fun testPasswordChanged() {
        val newPassword = "password123"
        viewModel.onUiEvent(LoginUiEvent.PasswordChanged(newPassword))

        TestCase.assertEquals(newPassword, viewModel.loginState.value.password)
        assertEquals(ErrorState(), viewModel.loginState.value.errorState.passwordErrorState)
    }

    @Test
    fun testSubmitWithValidInputs() {
        viewModel.onUiEvent(LoginUiEvent.EmailOrMobileChanged("test@example.com"))
        viewModel.onUiEvent(LoginUiEvent.PasswordChanged("password123"))
        viewModel.onUiEvent(LoginUiEvent.Submit)

        TestCase.assertTrue(viewModel.loginState.value.isLoginSuccessful)
        assertEquals(LoginErrorState(), viewModel.loginState.value.errorState)
    }

    @Test
    fun testSubmitWithEmptyEmailOrMobile() {
        viewModel.onUiEvent(LoginUiEvent.EmailOrMobileChanged(""))
        viewModel.onUiEvent(LoginUiEvent.PasswordChanged("password123"))
        viewModel.onUiEvent(LoginUiEvent.Submit)

        TestCase.assertFalse(viewModel.loginState.value.isLoginSuccessful)
        assertEquals(emailOrMobileEmptyErrorState, viewModel.loginState.value.errorState.emailOrMobileErrorState)
    }

    @Test
    fun testSubmitWithEmptyPassword() {
        viewModel.onUiEvent(LoginUiEvent.EmailOrMobileChanged("test@example.com"))
        viewModel.onUiEvent(LoginUiEvent.PasswordChanged(""))
        viewModel.onUiEvent(LoginUiEvent.Submit)

        TestCase.assertFalse(viewModel.loginState.value.isLoginSuccessful)
        assertEquals(passwordEmptyErrorState, viewModel.loginState.value.errorState.passwordErrorState)
    }
}