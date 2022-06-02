package com.example.cineapp.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id:Int,
    @SerializedName("original_title")
    val original_title:String,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("backdrop_path")
    val backdrop_path:String,
)
