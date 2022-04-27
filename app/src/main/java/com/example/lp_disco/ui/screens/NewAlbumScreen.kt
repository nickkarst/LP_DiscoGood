package com.example.lp_disco.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.ui.core.Text
import androidx.compose.material.Text
import com.example.lp_disco.data.AlbumWithTracks
import kotlin.reflect.KProperty

@Composable
fun newAlbumScreen(
    awtState: State<AlbumWithTracks>,
    onSaveAlbum: (AlbumWithTracks) -> Unit
){
    var awt = awtState.value
    var inputNameValue = remember { mutableStateOf("")}
    var inputAlbumValue = remember { mutableStateOf("")}
    var inputYearValue = remember { mutableStateOf("")}
    var b1 = false
    var b2 = false
    var b3 = false
    Column {
        OutlinedTextField(value = inputNameValue.value,
            onValueChange = {text ->
                awt!!.album.albumTitle = text
                b1 = true}
//            label = {Text(text = "Artist Name")}
        )
        OutlinedTextField(value = inputAlbumValue.value,
            onValueChange = {text ->
                awt!!.album.pYear = text
                b1 = true}
//            label = {Text(text = "Album Name")}
        )
        OutlinedTextField(value = inputYearValue.value,
            onValueChange = {text ->
                awt!!.album.artistName = text
                b1 = true}
//            label = {Text(text = "Year Published")}
        )
        var buttonEnable = false
        if (b1 && b2 && b3)
            buttonEnable = true
        Button(onClick = { onSaveAlbum(awt) },
        enabled = buttonEnable) {
            Text(
                text = "Save Album",
                textAlign = TextAlign.Center,
            )
        }
    }
}
