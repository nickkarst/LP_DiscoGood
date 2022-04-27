package com.example.lp_disco.ui.navigation.specs

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.*
import com.example.lp_disco.R
import com.example.lp_disco.ui.screens.AlbumDetails
import com.example.lp_disco.viewmodels.LPDiscoViewModel
import java.util.*

object AlbumDetailScreenSpec : LPScreenSpec {
    override val title = R.string.app_name
    override var route = "detial/{id}"
    override val arguments: List<NamedNavArgument> =
        listOf(navArgument("id") { type = NavType.StringType})

    override fun navigateTo(vararg args: String?): String {
        if (args == null) {
            route = "detail/0"
        } else {
            route = "detail/${args[0].toString()}"
        }
        return route
    }

    @Composable
    override fun Content (viewModel: LPDiscoViewModel,
                          navController: NavController,
                          navBackStackEntry: NavBackStackEntry
    ) {
        val arg = navBackStackEntry.arguments?.getString("id")
        val albumState = viewModel.awtLiveData.observeAsState()
        viewModel.loadAlbum(UUID.fromString(arg))
        albumState.value?.let { AlbumDetails(alb = it) }
    }
    @Composable
    override fun TopAppBarActions(navController: NavController) {
        IconButton(onClick = { ->
            navController.navigate(NewTrackScreenSpec.navigateTo())
        }) {
            Icon(imageVector = Icons.Filled.AddCircle,
                contentDescription = stringResource(
                    id = R.string.menu_add_album_desc
                )
            )
        }
    }
}