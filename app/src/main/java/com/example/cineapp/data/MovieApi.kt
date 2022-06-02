package com.example.cineapp.data

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MovieApi {

    @GET("popular?api_key=98fee347b91da83932ea8b9daa0edece")
    suspend fun getMovies() : MovieResponse

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun getPopular() : MovieResponse
}