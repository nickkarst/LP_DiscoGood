package com.example.lp_disco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.ui.core.Text
import com.example.lp_disco.data.AlbumWithTracks
import androidx.compose.ui.unit.dp
import com.example.lp_disco.data.LPTrack

private var totalMin = 0
private var totalSec = 0

@Composable
fun AlbumDetails(alb: AlbumWithTracks?) {
    Row {
        Text(text = alb!!.album.artistName)
        Text(text = alb.album.albumTitle)
        Text(text = "${alb.album.pYear}")
        Text(text = "Side A")
        showAlbumTracks(alb = alb, side = true)
        Text(text = "Side B")
        showAlbumTracks(alb = alb, side = false)
        Column {
            Text(text = "Total Time")
            Spacer(Modifier.width(24.dp))
            Text(text = "${totalMin}:${totalSec}")
        }
    }
}

@Composable
fun showAlbumTracks(alb: AlbumWithTracks, side: Boolean) {
    for (iter in 0..alb.tracks!!.size) {
        if (alb.tracks[iter]!!.side != side)
            continue
        Column {
            var track = alb.tracks[iter]
            Text(text = "${track?.tNum}")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = track!!.tTitle)
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "${track.tLenMin}:${track.tLenSec}")
            totalMin += track.tLenMin
            totalSec += track.tLenSec
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLocationScreen() {
    var alb: AlbumWithTracks? = null
    var tr: LPTrack? = null
    if (tr != null) {
        tr.id = 1
        tr.tLenSec = 30
        tr.tLenMin = 3
        tr.tTitle = "39"
        tr.side = true
        tr.tNum = 5
    }
    if (alb != null) {
        alb.album.albumTitle = "A Night at the Opera"
        alb.album.artistName = "Queen"
        alb.album.pYear = "1975"
        alb.album.id = 1
        alb.tracks!![0] = tr
    }
    AlbumDetails(alb = alb)
}