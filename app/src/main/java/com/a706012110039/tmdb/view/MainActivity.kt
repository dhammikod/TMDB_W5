package com.a706012110039.tmdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.tmdb.adapter.RVmovie
import com.a706012110039.tmdb.databinding.ActivityMainBinding
import com.a706012110039.tmdb.helper.Const
import com.a706012110039.tmdb.viewmodel.moviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVmovie
    private lateinit var viewModel: moviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(moviesViewModel::class.java)
        viewModel.getNowPlaying(Const.API_KEY, "en-US", 1)

        viewModel.nowPlaying.observe(this, Observer { response->
            binding.rvMain.layoutManager = LinearLayoutManager(this)
            adapter = RVmovie(response)
            binding.rvMain.adapter = adapter
            binding.progressBar.alpha = 0f
        })

    }
}