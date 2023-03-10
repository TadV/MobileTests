package com.tadvlasov.tooltests.features.gps

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tadvlasov.tooltests.core.ScreenWrapperWithNavView


@Composable
fun GpsScreen (navController: NavController) {
    ScreenWrapperWithNavView(navController, content = { GpsScreenContent() })
}

@Composable
fun GpsScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Тестирование GPS", //stringResource(R.string.app_name),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            ),
            textAlign = TextAlign.Center
        )
    }

}