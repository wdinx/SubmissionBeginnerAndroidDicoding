package com.example.submissionandroidbeginnner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Berita(
    val title: String,
    val writer: String,
    val date: String,
    val description: String,
    val image: Int
):Parcelable
