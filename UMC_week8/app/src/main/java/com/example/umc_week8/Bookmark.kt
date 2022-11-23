package com.example.umc_week8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bookmark(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name= "content") val content: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "memoId") val memoId: Int = 0
)
