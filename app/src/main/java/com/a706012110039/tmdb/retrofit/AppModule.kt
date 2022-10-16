package com.a706012110039.tmdb.retrofit

import com.a706012110039.tmdb.helper.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getretrovitservice(retrofit: Retrofit):EndPointAPI{
        return retrofit.create(EndPointAPI::class.java)
    }

    @Singleton
    @Provides
    fun getretrovitinstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}