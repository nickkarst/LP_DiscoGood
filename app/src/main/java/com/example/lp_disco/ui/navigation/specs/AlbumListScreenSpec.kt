package com.example.lp_disco.ui.navigation.specs

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.lp_disco.R
import com.example.lp_disco.ui.screens.AlbumListScreen
import com.example.lp_disco.util.AlbumGenerator
import com.example.lp_disco.viewmodels.LPDiscoViewModel

object AlbumListScreenSpec : LPScreenSpec {
    override val route = "list"
    override val arguments: List<NamedNavArgument> = listOf()
    override val title = R.string.app_name

    override fun navigateTo(vararg args: String?) : String {
        return route
    }

    @Composable
    override fun Content (viewModel: LPDiscoViewModel,
                          navController: NavController,
                          navBackStackEntry: NavBackStackEntry
    ) {
        val awtState = viewModel.awtListLiveData.observeAsState()
        awtState.value?.let { AlbumListScreen(
            albList = awtState.value,
            onAlbum = {album ->
                navController.navigate(AlbumDetailScreenSpec.navigateTo(
                    album.id.toString()
                ))
            }
        ) }
    }

    @Composable
    override fun TopAppBarActions(navController: NavController) {
        IconButton(onClick = { ->
            navController.navigate(NewAlbumScreenSpec.navigateTo())
        }) {
            Icon(imageVector = Icons.Filled.AddCircle,
                contentDescription = stringResource(
                    id = R.string.menu_add_album_desc
                )
            )
        }
    }
}