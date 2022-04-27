package com.example.lp_disco.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign
import androidx.ui.core.Text
import com.example.lp_disco.data.AlbumWithTracks

@Composable
fun newTrackScreen(alb: AlbumWithTracks,
onSaveTrack: () -> Unit) {
    Row {
       Text(text = alb.album.albumTitle)
       Text(text = alb.album.artistName)
       Text(text = "${alb.album.pYear}")
        var inputTrackNum by remember { mutableStateOf("") }
        var inputTrackTitle by remember { mutableStateOf("") }
        var inputMin by remember { mutableStateOf("") }
        var inputSec by remember { mutableStateOf("") }
        var b1 = false
        var b2 = false
        var b3 = false
        var b4 = false
        var b5 = false
        var side = false
        OutlinedTextField(value = inputTrackNum,
            onValueChange = {inputTrackNum = it
                b1 = true},
            label = {Text(text = "Track Number")})
        OutlinedTextField(value = inputTrackTitle,
            onValueChange = {inputTrackTitle = it
                b2 = true},
            label = {Text(text = "Track Title")})
        OutlinedTextField(value = inputMin,
            onValueChange = {inputMin = it
                b3 = true},
            label = {Text(text = "Track Length Minutes")})
        OutlinedTextField(value = inputSec,
            onValueChange = {inputSec = it
                b4 = true},
            label = {Text(text = "Track Length Seconds")})
        Text(text = "Album Side")

        Column {
            Button(onClick = { side = true
                             b5 = true}) {
                androidx.compose.material.Text(
                    text = "A",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = { side = false
                b5 = true}) {
                androidx.compose.material.Text(
                    text = "B",
                    textAlign = TextAlign.Center,
                )
            }
        }
        var buttonEnable = false
        if (b1 && b2 && b3 && b4 && b5)
            buttonEnable = true
        Button(onClick = {onSaveTrack},
        enabled = buttonEnable) {
            androidx.compose.material.Text(
                text = "Save Track",
                textAlign = TextAlign.Center,
            )
        }
    }
}