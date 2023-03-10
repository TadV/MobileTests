package com.tadvlasov.tooltests.features.rest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tadvlasov.tooltests.core.ScreenWrapperWithNavView


@Composable
fun RestScreen (navController: NavController) {
    ScreenWrapperWithNavView(navController, content = { RestScreenContent() })
}

@Composable
private fun RestScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Тестирование REST", //stringResource(R.string.app_name),
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
        Button(
            onClick = {
                ApiConnector.test()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 10.dp)
                .height(50.dp),
        ) {
            Text(
                text = "Test Auth",
                fontSize = 20.sp,
            )
        }
    }
}