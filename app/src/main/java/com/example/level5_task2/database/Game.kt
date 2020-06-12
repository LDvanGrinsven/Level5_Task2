package com.example.level5_task2.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "game")
data class Game(
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: Long,

    @ColumnInfo(name = "platform ")
    var platform: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
): Parcelable