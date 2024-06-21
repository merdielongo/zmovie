package com.elongocrea.zmovie.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListIntConvert {

    @TypeConverter
    fun fromList(value: List<Int>?): String? {
        return if (value == null) null else Gson().toJson(value)
    }

    @TypeConverter
    fun toList(value: String?): List<Int>? {
        return if (value == null) null else Gson().fromJson(value, object : TypeToken<List<Int>>() {}.type)
    }
}
