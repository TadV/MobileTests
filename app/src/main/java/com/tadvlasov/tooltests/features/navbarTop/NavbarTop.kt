package com.tadvlasov.tooltests.features.navbarTop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class NavbarTop {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowView( onclick = {} )
}

@Composable
fun NavbarTopView(navController: NavController) {
    RowView ( onclick = { navController.popBackStack() } )
}

@Composable
private fun RowView (onclick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
    ) {
        Button(
            onClick = onclick,
            modifier = Modifier
                .size(50.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Return",
                tint = Color.Red,
            )
        }
    }
}