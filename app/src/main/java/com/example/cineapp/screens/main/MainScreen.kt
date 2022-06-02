package com.example.cineapp.screens.main



import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.cineapp.screens.main.components.MovieListItem
import com.example.cineapp.screens.main.components.SearchBar
import com.example.cineapp.screens.util.Resource
import com.example.cineapp.screens.util.Screen
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val getMovies = viewModel.getMovies.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Peliculas")
                }
            )
        }
    ){
        scope.launch {
            val result = viewModel.getMovies()

            if(result is Resource.Success) {
                Toast.makeText(context, "Fetching data success!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Error: ${result.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        if(!viewModel.isLoading.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        if(viewModel.isLoading.value) {
            if(viewModel.getMovies.value != null){
                Column{
                    SearchBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(CenterHorizontally)
                    )
                    LazyColumn(modifier = Modifier.padding(10.dp)){
                        items(getMovies.value!!.results.size){ index ->
                            MovieListItem(
                                getMovies.value!!.results[index],
                                onClick = {
                                    navController.navigate(Screen.DetailsScreen.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

//"https://image.tmdb.org/t/p/w780/${getMovies.value!!.results[index].backdrop_path}"


