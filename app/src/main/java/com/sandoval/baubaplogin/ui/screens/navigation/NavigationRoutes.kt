package com.sandoval.baubaplogin.ui.screens.navigation

sealed class NavigationRoutes {
    sealed class Unauthenticated(val route: String) : NavigationRoutes() {
        object NavigationRoute : Unauthenticated(route = "unauthenticated")
        object Login : Unauthenticated(route = "login")
    }

    sealed class Authenticated(val route: String) : NavigationRoutes() {
        object NavigationRoute : Authenticated(route = "authenticated")
        object DashboardHome : Authenticated(route = "dashboard_home")
    }
}
