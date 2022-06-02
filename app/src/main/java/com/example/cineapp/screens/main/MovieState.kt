package com.example.cineapp.screens.main

import com.example.cineapp.data.Movie

data class MovieState(
    val movies: List<Movie> = emptyList()
)