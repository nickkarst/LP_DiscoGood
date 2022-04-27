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

@Composable
private fun AlbumRow(albObj: LPAlbum,
                     onAlbum: (LPAlbum) -> Unit
) {
    Card(modifier = Modifier.clickable { onAlbum(albObj) }) {
        Row {
           Text(text = "${albObj.artistName}",
           Modifier.size(24.dp))
           Spacer(modifier = Modifier.width(24.dp))
           Column {
               Text(text = "${albObj.albumTitle}")
               Row() {
                   Text(text = "${albObj.pYear}")
               }
           } 
        }
    }
}

@Composable
fun AlbumListScreen(albList: List<AlbumWithTracks>?,
onAlbum: (LPAlbum) -> Unit) {
    if (albList != null) {
        LazyColumn {
            items(albList) {
                alb ->
                AlbumRow(albObj = alb.album,
                    onAlbum = onAlbum)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewAlbumListScreen() {

}