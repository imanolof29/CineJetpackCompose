package com.example.cineapp.data.repository

import com.example.cineapp.data.MovieApi
import com.example.cineapp.data.MovieResponse
import com.example.cineapp.screens.util.Resource
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl
    @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getMovies(): Resource<MovieResponse> {
        val response = try {
            api.getMovies()
        }catch (e: Exception) {
            return Resource.Error("An unknown error occurred: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }

    override suspend fun getPopular(): MovieResponse {
        return api.getPopular()
    }
}