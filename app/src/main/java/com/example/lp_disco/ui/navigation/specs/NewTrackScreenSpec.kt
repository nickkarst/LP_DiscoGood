package com.example.lp_disco.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.lp_disco.R
import com.example.lp_disco.ui.screens.newAlbumScreen
import com.example.lp_disco.viewmodels.LPDiscoViewModel

object NewTrackScreenSpec : LPScreenSpec {
    override val title = R.string.app_name
    override var route = "newTrack"
    override val arguments: List<NamedNavArgument> = listOf()

    override fun navigateTo(vararg args: String?) : String {
        return route
    }

    @Composable
    override fun Content (viewModel: LPDiscoViewModel,
                          navController: NavController,
                          navBackStackEntry: NavBackStackEntry
    ) {
//        val workInfoState = viewModel.outputWorkerInfo.observeAsState()
//        workInfoState.value?.let { workInfo ->
//            when(workInfo.state) {
//                WorkInfo.State.ENQUEUED -> Log.d(LOG_TAG, "workInfo enqueued")
//                WorkInfo.State.RUNNING -> Log.d(LOG_TAG, "workInfo running")
//                WorkInfo.State.SUCCEEDED -> {
//                    Log.d(LOG_TAG, "workInfo succeeded")
//                    val apiData = CharacterWorker.getApiData( workInfo.outputData )
//                    Log.d(LOG_TAG, "Got api data $apiData")
//                    if(apiData != null) {
//                        val (race, name, dex, wis, str) = apiData.split(",")
//                        val apiCharacter = SamodelkinCharacter(name, race, dex, wis, str )
//                        characterState.value = apiCharacter
//                    } else {}
//                }
//                else -> Log.d(LOG_TAG, "other workInfo state")
//            }
//        }
//        newAlbumScreen(
//            onSaveAlbum = {awt ->
//                viewModel.addAlbum(awt.album)
//                navController.popBackStack(route = AlbumDetailScreenSpec.navigateTo(),
//                    inclusive = false)
//            }
//        )
    }

    @Composable
    override fun TopAppBarActions(navController: NavController){}
}