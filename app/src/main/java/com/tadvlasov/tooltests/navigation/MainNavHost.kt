package com.tadvlasov.tooltests.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.tadvlasov.tooltests.core.StartScreen
import com.tadvlasov.tooltests.features.gps.GpsScreen
import com.tadvlasov.tooltests.features.rest.RestScreen
import com.tadvlasov.tooltests.features.roomdb.RoomDBScreen

sealed class NavRoute(val route: String, val name: String = "") {
    object StartScreen: NavRoute("start_screen", "MAIN")
    object RestScreen: NavRoute("rest_screen", "REST")
    object GpsScreen: NavRoute("gps_screen", "GPS")
    object RoomDBScreen: NavRoute("roomdb_screen","DB")
}
@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) {
            StartScreen(navController = navController)
        }
        composable(NavRoute.RestScreen.route) {
            RestScreen(navController = navController)
        }
        composable(NavRoute.GpsScreen.route) {
            GpsScreen(navController = navController)
        }
        composable(NavRoute.RoomDBScreen.route) {
            RoomDBScreen(navController = navController)
        }
    }
}