package com.tadvlasov.tooltests.features.navbarBottom

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tadvlasov.tooltests.navigation.NavRoute

class NavbarBottom {
    companion object {
        fun mainButtonRoutesList(): List<NavRoute> {
            return listOf(
                NavRoute.StartScreen,
                NavRoute.GpsScreen,
                NavRoute.RestScreen,
                NavRoute.RoomDBScreen
            )
        }
    }
}

@Composable
fun NavbarBottomView(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavbarBottom.mainButtonRoutesList().forEach {
            val currentRoute = navController.currentBackStackEntry?.destination?.route
            Button(
                enabled = (currentRoute != it.route) ,
                onClick = { navController.navigate(it.route) {} },
                modifier = Modifier
                    .padding(10.dp, 10.dp)
                    .height(50.dp),
            ) {
                Text(
                    text = it.name,
                    fontSize = 20.sp,
                )
            }
        }
    }
}