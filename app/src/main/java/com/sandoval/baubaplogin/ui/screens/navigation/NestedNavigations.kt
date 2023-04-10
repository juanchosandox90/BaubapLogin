package com.sandoval.baubaplogin.ui.screens.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sandoval.baubaplogin.ui.screens.dashboard_home.DashBoardHomeScreen
import com.sandoval.baubaplogin.ui.screens.login.LoginScreen

/**
 * Pantalla de Login
 */
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Unauthenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Login.route
    ) {
        composable(route = NavigationRoutes.Unauthenticated.Login.route) {
            LoginScreen(onNavigateToAuthenticatedRoute = {
                navController.navigate(route = NavigationRoutes.Authenticated.NavigationRoute.route) {
                    popUpTo(route = NavigationRoutes.Unauthenticated.NavigationRoute.route) {
                        inclusive = true
                    }
                }
            })
        }
    }
}


/**
 * Pantalla del dashboard home
 */
fun NavGraphBuilder.authenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Authenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Authenticated.DashboardHome.route
    ) {
        composable(route = NavigationRoutes.Authenticated.DashboardHome.route) {
            DashBoardHomeScreen()
        }
    }
}