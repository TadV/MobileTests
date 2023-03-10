package com.tadvlasov.tooltests.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tadvlasov.tooltests.features.navbarBottom.NavbarBottomView
import com.tadvlasov.tooltests.features.navbarTop.NavbarTopView

class ScreenWrapperWithNav {
}

@Composable
fun ScreenWrapperWithNavView (
    navController: NavController,
    content: @Composable() (PaddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { NavbarTopView(navController) },
        content = { content(it) },
        bottomBar = { NavbarBottomView(navController) }
    )
}