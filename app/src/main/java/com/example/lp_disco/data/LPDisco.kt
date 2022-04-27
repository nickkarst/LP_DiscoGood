package com.example.lp_disco.data

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable
import java.util.*


@Entity(tableName = "album")
data class LPAlbum (
    var i: Int,
    var an: String,
    var at: String,
    var py: String): Serializable {
    @PrimaryKey var albumId: UUID = UUID.randomUUID()
    var id = i
    var artistName = an
    var albumTitle = at
    var pYear = py
    }

@Entity(tableName = "track")
data class LPTrack (
    @PrimaryKey var id: Int,
    val trackAlbID: String,
    var side: Boolean,
    var tNum: Int,
    var tTitle: String,
    var tLenMin: Int,
    var tLenSec: Int
)