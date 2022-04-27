package com.example.lp_disco.ui.navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.graphics.Color
import com.example.lp_disco.R
import com.example.lp_disco.ui.navigation.specs.LPScreenSpec
import com.example.lp_disco.viewmodels.LPDiscoViewModel

@Composable
fun LPDiscoNavHost(navController: NavController,
                      viewModel: LPDiscoViewModel) {
    NavHost(navController = navController as NavHostController,
        startDestination = BottomNavItem.Albums.screen_route) {
        LPScreenSpec.allscreens.forEach { (route, screen) ->
            if (screen != null) {
                composable(
                    route = screen.route,
                    arguments = screen.arguments
                ) { navBackStackEntry ->
                    screen.Content(viewModel = viewModel,
                        navController = navController,
                        navBackStackEntry = navBackStackEntry)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Albums,
        BottomNavItem.Songs
    )
    androidx.compose.material.BottomNavigation (
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}