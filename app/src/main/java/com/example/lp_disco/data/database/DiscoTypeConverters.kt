package com.example.lp_disco.data.database

import androidx.room.TypeConverter
import java.util.*

class DiscoTypeConverters {
    @TypeConverter
    fun fromUUID(id: UUID?) = id?.toString()

    @TypeConverter
    fun toUUID(string: String?) = UUID.fromString(string)
}