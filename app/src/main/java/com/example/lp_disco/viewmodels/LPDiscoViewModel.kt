package com.example.lp_disco.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack
import java.util.*

abstract class LPDiscoViewModel : ViewModel() {
    abstract val awtListLiveData: LiveData<List<AlbumWithTracks>>
    abstract val awtLiveData: LiveData<AlbumWithTracks?>

    abstract fun addAlbum (obj: LPAlbum) //gets implemented in DiscoViewModel
    abstract fun loadAlbum (uuid: UUID)
    abstract fun addTrack (obj: LPTrack)
    abstract fun addAwt (alb: LPAlbum) : AlbumWithTracks
}