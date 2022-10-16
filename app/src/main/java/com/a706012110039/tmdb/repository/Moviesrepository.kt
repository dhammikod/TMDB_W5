package com.a706012110039.tmdb.repository

import com.a706012110039.tmdb.retrofit.EndPointAPI
import javax.inject.Inject

class NowPlayingRepository @Inject constructor(private val api: EndPointAPI){

    suspend fun  getNowPlayingData
                (
        apiKey: String,
        language: String,
        page:Int
    ) = api.getNowPlaying(apiKey, language,page)

    suspend fun  getmovieplayingresult
                (
        apiKey: String,
        id: Int,
    ) = api.getmoviedetails(id, apiKey)

}