package com.example.lp_disco.ui.navigation

import com.example.lp_disco.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Albums : BottomNavItem("Albums", R.drawable.lp_album_icon,"list")
    object Songs: BottomNavItem("Songs",R.drawable.lp_note,"trackList")

}