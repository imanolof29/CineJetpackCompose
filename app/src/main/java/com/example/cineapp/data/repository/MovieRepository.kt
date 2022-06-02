package com.example.cineapp.data.repository

import com.example.cineapp.data.Movie
import com.example.cineapp.data.MovieResponse
import com.example.cineapp.screens.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies() : Resource<MovieResponse>

    suspend fun getPopular() : MovieResponse

}