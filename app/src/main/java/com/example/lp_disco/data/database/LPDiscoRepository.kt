package com.example.lp_disco.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack
import java.util.*
import java.util.concurrent.Executors

class LPDiscoRepository private constructor(private val lpDiscoDao: LPDiscoDao) {
    companion object {
        @Volatile private var INSTANCE: LPDiscoRepository? = null
        fun getInstance(context: Context): LPDiscoRepository {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    val database = DiscoDatabase.getInstance(context = context)
                    instance = LPDiscoRepository(database.discoDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val executor = Executors.newSingleThreadExecutor()

    fun getAlbumsWithTracks(): LiveData<List<AlbumWithTracks>> =
        lpDiscoDao.getAlbumsWithTracks()
    fun getSingleWithTracks(id: UUID): LiveData<AlbumWithTracks?> =
        lpDiscoDao.getSingleWithTracks(id)


    fun addAlbum(albObj: LPAlbum) {
        executor.execute {
            lpDiscoDao.addAlbum(albObj)
        }
    }

    fun addTrack(trObj: LPTrack) {
        executor.execute {
            lpDiscoDao.addTrack(trObj)
        }
    }
}