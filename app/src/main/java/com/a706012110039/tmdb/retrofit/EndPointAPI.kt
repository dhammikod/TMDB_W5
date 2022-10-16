package com.a706012110039.tmdb.retrofit

import com.a706012110039.tmdb.model.MovieDetails
import com.a706012110039.tmdb.model.NowPlaying

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPointAPI {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apikey: String,
        @Query("language") languange: String,
        @Query("page") page: Int
    ):Response<NowPlaying>

    @GET("movie/{id}")
    suspend fun getmoviedetails(
        @Path("id") id: Int,
        @Query("api_key") apikey: String,

    ):Response<MovieDetails>
}