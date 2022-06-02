package com.example.cineapp.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cineapp.data.MovieResponse
import com.example.cineapp.data.repository.MovieRepositoryImpl
import com.example.cineapp.screens.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepositoryImpl
) : ViewModel(){

    var isLoading = mutableStateOf(false)
    private var _getMovies: MutableLiveData<MovieResponse> = MutableLiveData<MovieResponse>()
    var getMovies: LiveData<MovieResponse> = _getMovies

    suspend fun getMovies(): Resource<MovieResponse> {
        val result = repository.getMovies()
        if(result is Resource.Success) {
            isLoading.value = true
            _getMovies.value = result.data!!
        }
        return result
    }

    fun searchMovie(query:String) {
         val listToSearch = _getMovies.value
        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()) {
                getMovies = _getMovies
            }
        }
    }
}