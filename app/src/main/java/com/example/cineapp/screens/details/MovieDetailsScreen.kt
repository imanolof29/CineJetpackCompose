package com.example.cineapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.cineapp.data.Movie

@ExperimentalCoilApi
@Composable
fun MovieDetailsScreen(movie: Movie) {
    Column{
        Text(movie.original_title)
    }
}