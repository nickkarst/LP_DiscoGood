package com.example.lp_disco.util

import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack

object AlbumGenerator {
    private fun id () = 1
    private fun artistName() = "Queen"
    private fun albumTitle() = "A Night at the Opera"
    private fun pYear() = "1975"

    private val songNames = listOf(
        "Death on Two Legs",
        "Lazing on a Sunday Afternoon",
        "I'm in Love with my Car",
        "You're My Best Friend",
        "39",
        "Sweet Lady",
        "Seaside Rendezvous",
        "The Prophet's Song",
        "Love of My Life",
        "Good Company",
        "Bohemian Rhapsody",
        "God Save the Queen (instrumental)"
    )

    private val sides = listOf(true, true, true, true, true, true, true,
        false, false, false, false, false)
    private val tLenMin = listOf(3, 1, 3, 2, 3, 4, 2, 8, 3, 3, 5, 1)
    private val tLenSec = listOf(43, 8, 5, 50, 30, 1, 13, 21, 38, 26 ,55, 11)

    private fun genTrackList(): MutableList<LPTrack?>? {
        var retList: MutableList<LPTrack?>? = arrayListOf()
        for (iter in 0..(songNames.size - 1)) {
            fun id() = iter + 1
            fun trackAlbID() = "A Night at the Opera"
            fun side() = sides[iter]
            fun tNum() = iter + 1
            fun tTitle() = songNames[iter]
            fun tLenMin() = tLenMin[iter]
            fun tLenSec() = tLenSec[iter]
            retList!!.add(LPTrack(id = id(), trackAlbID = trackAlbID(), side(), tNum(), tTitle = tTitle(),
            tLenMin = tLenMin(), tLenSec = tLenSec()))
        }
        return retList
    }

    fun generateAlbum() = LPAlbum(id(), artistName(), albumTitle(), pYear())
    fun generateAwt() = AlbumWithTracks(generateAlbum(), genTrackList())
}