package com.a706012110039.tmdb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a706012110039.tmdb.model.MovieDetails
import com.a706012110039.tmdb.repository.NowPlayingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.a706012110039.tmdb.model.Result

@HiltViewModel
class moviesViewModel @Inject constructor(
    private val
    repository: NowPlayingRepository
) : ViewModel() {

    val _nowPlaying: MutableLiveData<ArrayList<Result>> by lazy {
        MutableLiveData<ArrayList<Result>>()
    }

    val nowPlaying: MutableLiveData<ArrayList<Result>>
        get() = _nowPlaying

    fun getNowPlaying(apiKey: String, language: String, page: Int) =
        viewModelScope.launch {
            repository.getNowPlayingData(apiKey, language, page).let { response ->
                if (response.isSuccessful) {
                    _nowPlaying.postValue(response.body()?.results as ArrayList<Result>?)
                } else {
                    Log.e("get data", "failed")
                }
            }
        }

    //get details
    val _moviedetails: MutableLiveData<MovieDetails> by lazy {
        MutableLiveData<MovieDetails>()
    }

    val moviedetails: MutableLiveData<MovieDetails>
        get() = _moviedetails

    fun getmoviedetails(apiKey: String, id: Int) =
        viewModelScope.launch {
            repository.getmovieplayingresult(apiKey, id).let { response ->
                if (response.isSuccessful) {
                    _moviedetails.postValue(response.body() as MovieDetails)
                } else {
                    Log.e("get data", "failed")
                }
            }
        }
}