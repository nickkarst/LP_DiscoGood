package com.example.lp_disco.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack
import com.example.lp_disco.data.database.LPDiscoRepository
import com.example.lp_disco.util.DiscoWorker
import java.util.*

class DiscoViewModel (
    private val lpDiscoRepository: LPDiscoRepository,
    context: Context) : LPDiscoViewModel () {

    private val workManager = WorkManager.getInstance(context)
    private val workRequest = DiscoWorker.buildOneTimeWorkRequest()

    private val _discoIdLiveData = MutableLiveData<UUID>()

    override val awtListLiveData: LiveData<List<AlbumWithTracks>>
        get() = lpDiscoRepository.getAlbumsWithTracks()

    override val awtLiveData: LiveData<AlbumWithTracks?> =
        Transformations.switchMap(_discoIdLiveData) {
            albumId ->
            lpDiscoRepository.getSingleWithTracks(albumId)
        }

    override fun addAlbum(obj: LPAlbum) {
        lpDiscoRepository.addAlbum(obj)
    }

    override fun addAwt(alb: LPAlbum) : AlbumWithTracks {
        val awt = AlbumWithTracks(album = alb, tracks = null)
        return awt
    }

    override fun addTrack(obj: LPTrack) {
        lpDiscoRepository.addTrack(obj)
    }

    override fun loadAlbum(uuid: UUID) {
        _discoIdLiveData.value = uuid
    }

}