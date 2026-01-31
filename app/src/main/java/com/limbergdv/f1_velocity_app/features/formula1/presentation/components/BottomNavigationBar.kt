package com.limbergdv.f1_velocity_app.features.formula1.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class NavigationItem {
    HOME,
    DRIVERS,
    TEAMS,
    CIRCUITS
}

@Composable
fun BottomNavigationBar(
    selectedItem: NavigationItem = NavigationItem.HOME,
    onItemSelected: (NavigationItem) -> Unit = {}
) {
    NavigationBar(
        containerColor = Color(0xFFDC0000),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = selectedItem == NavigationItem.HOME,
            onClick = { onItemSelected(NavigationItem.HOME) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Home", fontSize = 12.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.6f),
                unselectedTextColor = Color.White.copy(alpha = 0.6f),
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedItem == NavigationItem.DRIVERS,
            onClick = { onItemSelected(NavigationItem.DRIVERS) },
            icon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
                    contentDescription = "Drivers",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Drivers", fontSize = 12.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.6f),
                unselectedTextColor = Color.White.copy(alpha = 0.6f),
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedItem == NavigationItem.TEAMS,
            onClick = { onItemSelected(NavigationItem.TEAMS) },
            icon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_compass),
                    contentDescription = "Teams",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Teams", fontSize = 12.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.6f),
                unselectedTextColor = Color.White.copy(alpha = 0.6f),
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedItem == NavigationItem.CIRCUITS,
            onClick = { onItemSelected(NavigationItem.CIRCUITS) },
            icon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_info_details),
                    contentDescription = "Circuits",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Circuits", fontSize = 12.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.6f),
                unselectedTextColor = Color.White.copy(alpha = 0.6f),
                indicatorColor = Color.Transparent
            )
        )
    }
}
