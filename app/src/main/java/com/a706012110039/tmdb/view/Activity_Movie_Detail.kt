package com.a706012110039.tmdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.tmdb.adapter.RVSpokenLanguange
import com.a706012110039.tmdb.adapter.RVgenre
import com.a706012110039.tmdb.adapter.RVprodcompany
import com.a706012110039.tmdb.adapter.RVprodcountry
import com.a706012110039.tmdb.databinding.ActivityMovieDetail2Binding
import com.a706012110039.tmdb.helper.Const
import com.a706012110039.tmdb.viewmodel.moviesViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity_Movie_Detail : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetail2Binding
    private lateinit var nowplayingview: moviesViewModel
    private lateinit var genreadaptor: RVgenre
    private lateinit var spokenlangadaptor: RVSpokenLanguange
    private lateinit var prodcountryadaptor: RVprodcountry
    private lateinit var prodlogoadaptor: RVprodcompany

    override fun onCreate(savedInstanceState: Bundle?) {
        var temp = ArrayList<String>()
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val movieid = intent.getIntExtra("movieid",0)
        nowplayingview = ViewModelProvider(this)[moviesViewModel::class.java]
        nowplayingview.getmoviedetails(Const.API_KEY, movieid)

        nowplayingview.moviedetails.observe(this) { response ->
            binding.titleMoviedetail.apply {
                text = response.title
            }
            binding.descMoviedetail.apply {
                text = response.overview
            }
            Glide.with(applicationContext).load(Const.IMG_URL + response.backdrop_path).into(binding.imgPoster)

            Glide.with(applicationContext).load(Const.IMG_URL + response.poster_path).into(binding.imageView)

            genreadaptor = RVgenre(response.genres)
            binding.RVGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.RVGenre.adapter = genreadaptor

            spokenlangadaptor = RVSpokenLanguange(response.spoken_languages)
            binding.RVSpokenlanguange.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.RVSpokenlanguange.adapter = spokenlangadaptor

            prodcountryadaptor = RVprodcountry(response.production_countries)
            binding.RVProdcountry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.RVProdcountry.adapter = prodcountryadaptor

//            response.production_companies.filter { a-> a.logo_path != null }

            prodlogoadaptor = RVprodcompany(response.production_companies)
            binding.RVProductioncompany.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.RVProductioncompany.adapter = prodlogoadaptor

            binding.progresscard.alpha = 0f
        }
    }
}