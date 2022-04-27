package com.example.lp_disco.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lp_disco.ui.navigation.specs.LPScreenSpec

@Composable
fun LPDiscoTopBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    LPScreenSpec.TopBar(navController = navController,
        navBackStackEntry = navBackStackEntry)
}