package com.example.lp_disco.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack

@Database(entities = [LPAlbum::class, LPTrack::class], version=1, exportSchema = false)
@TypeConverters(DiscoTypeConverters::class)
abstract class DiscoDatabase: RoomDatabase() {
    companion object {
        @Volatile private var INSTANCE: DiscoDatabase? = null
        fun getInstance(context: Context): DiscoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                        DiscoDatabase::class.java,
                        "disco-database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
    abstract val discoDao: LPDiscoDao
}