package com.example.lp_disco.ui.navigation.specs

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.work.WorkInfo
import com.example.lp_disco.R
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.ui.screens.newAlbumScreen
import com.example.lp_disco.viewmodels.LPDiscoViewModel


object NewAlbumScreenSpec : LPScreenSpec {
    override val title = R.string.app_name
    override var route = "newAlbum"
    override val arguments: List<NamedNavArgument> = listOf()

    override fun navigateTo(vararg args: String?) : String {
        return route
    }

    @Composable
    override fun Content (viewModel: LPDiscoViewModel,
                          navController: NavController,
                          navBackStackEntry: NavBackStackEntry
    ) {
        fun generateAlbum() = LPAlbum(i = 0, an = "", at = "", py = "")
        val awtState = rememberSaveable {
            mutableStateOf( viewModel.addAwt(generateAlbum()) )
        }
        newAlbumScreen(
            awtState = awtState,
            onSaveAlbum = {awt ->
                viewModel.addAlbum(awt.album)
                navController.popBackStack(route = AlbumListScreenSpec.navigateTo(),
                inclusive = false)
            }
        )
    }

    @Composable
    override fun TopAppBarActions(navController: NavController){}
}