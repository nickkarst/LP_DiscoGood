package com.example.lp_disco.data

import androidx.room.Embedded
import androidx.room.Relation

data class AlbumWithTracks(
    @Embedded val album: LPAlbum,
    @Relation(
        parentColumn = "albumId",
        entityColumn = "trackAlbID"
    )
    val tracks: MutableList<LPTrack?>?
)