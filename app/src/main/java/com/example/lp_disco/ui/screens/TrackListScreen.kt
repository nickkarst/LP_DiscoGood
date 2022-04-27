package com.example.lp_disco.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.ui.text.style.TextAlign
import com.example.lp_disco.data.AlbumWithTracks
import com.example.lp_disco.data.LPAlbum
import com.example.lp_disco.data.LPTrack

@Composable
private fun TrackRow(trObj: LPTrack,
                     onTrack: (LPTrack) -> Unit,
                     artName: String
) {
//    Card(modifier = Modifier.clickable { onTrack(trObj) }) {
//        Column {
//            Text(text = "${trObj.tTitle}")
//            Spacer(modifier = Modifier.width(24.dp))
//            Text(text = "${artName}")
//            Spacer(modifier = Modifier.width(24.dp))
//            if (trObj.side)
//                Text(text = "${trObj.album} (A)")
//            else
//                Text(text = "${trObj.album} (B)")
//            Spacer(modifier = Modifier.width(24.dp))
//            Text(text = "${trObj.tLenMin}:${trObj.tLenSec}")
//        }
//    }
}

@Composable
fun TrackListScreen(atObj: List<AlbumWithTracks>?,
                    onTr: (LPTrack) -> Unit) {
    if (atObj != null) {
        LazyColumn {
            items(atObj) { obj ->
                for (iter in 0..obj.tracks!!.size) {
                    Column {
                        var track = obj.tracks[iter]
                        var side = ""
                        if (track!!.side) side = "A"
                        else side = "B"
                        androidx.ui.core.Text(text = track!!.tTitle)
                        Spacer(modifier = Modifier.width(10.dp))
                        androidx.ui.core.Text(text = obj.album.artistName)
                        Spacer(modifier = Modifier.width(10.dp))
                        androidx.ui.core.Text(text = "${track!!.trackAlbID} " +
                                "(${side}")
                        Spacer(modifier = Modifier.width(24.dp))
                        androidx.ui.core.Text(text = "${track.tLenMin}:${track.tLenSec}")
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewAlbumListScreen() {

}