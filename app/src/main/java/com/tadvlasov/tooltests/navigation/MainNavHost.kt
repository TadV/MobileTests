package com.tadvlasov.tooltests.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.tadvlasov.tooltests.core.StartScreen

sealed class NavRoute(val route: String) {
    object StartScreen: NavRoute("start_screen")
}
@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) {
            StartScreen(navController = navController)
        }
    }
}