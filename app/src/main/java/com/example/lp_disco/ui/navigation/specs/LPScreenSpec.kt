package com.example.lp_disco.ui.navigation.specs

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.lp_disco.R
import com.example.lp_disco.viewmodels.LPDiscoViewModel


sealed interface LPScreenSpec {
    val route: String
    val arguments: List<NamedNavArgument>
    val title: Int

    companion object {
        val startDestination = AlbumListScreenSpec.route
        val allscreens = LPScreenSpec::class.sealedSubclasses.associate { it.objectInstance?.route to it.objectInstance }

        @Composable
        fun TopBar(navController: NavController, navBackStackEntry: NavBackStackEntry?) {
            val route = navBackStackEntry?.destination?.route ?: ""
            allscreens[route]?.TopAppBarContent(navController)
        }
    }

    @Composable
    private fun TopAppBarContent (navController: NavController) {
        TopAppBar (
            navigationIcon = {
                if (navController.previousBackStackEntry != null) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(
                                id = R.string.menu_back_desc))
                    }
                } else null
            },
            title =  {
                Text(text = stringResource(id = title))
            },
            actions = {
                TopAppBarActions(navController = navController)
            }
        )
    }

    @Composable
    fun Content (viewModel: LPDiscoViewModel,
                 navController: NavController,
                 navBackStackEntry: NavBackStackEntry)

    @Composable
    fun TopAppBarActions (navController: NavController)

    fun navigateTo(vararg args: String?) : String

}