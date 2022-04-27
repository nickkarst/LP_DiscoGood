package com.example.lp_disco.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack
import java.util.*

@Dao
interface LPDiscoDao {
    @Transaction
    @Query("SELECT * FROM album")
    fun getAlbumsWithTracks(): LiveData<List<AlbumWithTracks>>

    @Transaction
    @Query("SELECT * FROM album WHERE id=(:id)")
    fun getSingleWithTracks(id: UUID): LiveData<AlbumWithTracks?>

    @Insert
    fun addAlbum(alObj: LPAlbum)
    @Insert
    fun addTrack(trObj: LPTrack)
}