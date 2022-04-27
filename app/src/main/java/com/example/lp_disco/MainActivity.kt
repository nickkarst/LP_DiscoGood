package com.example.lp_disco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.lp_disco.ui.navigation.BottomNavigation
import com.example.lp_disco.ui.navigation.LPDiscoNavHost
import com.example.lp_disco.ui.navigation.LPDiscoTopBar
import com.example.lp_disco.ui.theme.LP_DiscoTheme
import com.example.lp_disco.viewmodels.DiscoViewModel
import com.example.lp_disco.viewmodels.LPDiscoViewModel
import com.example.lp_disco.viewmodels.ViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var instance: DiscoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        val factory = ViewModelFactory(this)
        instance = ViewModelProvider(this, factory = factory)[factory.getViewModelClass()]
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent(viewModel = instance)
        }
    }
}

@Composable
private fun MainActivityContent(viewModel: LPDiscoViewModel) {
    LP_DiscoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            Scaffold(topBar = { LPDiscoTopBar(navController = navController) },
            bottomBar = { BottomNavigation(navController = navController)}) {
                LPDiscoNavHost(
                    navController = navController,
                    viewModel = viewModel
                )

            }
        }
    }
}