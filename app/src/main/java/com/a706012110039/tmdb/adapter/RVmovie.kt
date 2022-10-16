package com.a706012110039.tmdb.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.a706012110039.tmdb.R
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.tmdb.databinding.CardNowPlayingBinding
import com.a706012110039.tmdb.helper.Const
import com.a706012110039.tmdb.model.Result
import com.a706012110039.tmdb.view.Activity_Movie_Detail
import com.bumptech.glide.Glide

class RVmovie(private val dataSet: ArrayList<Result>) :
        RecyclerView.Adapter<RVmovie.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardNowPlayingBinding.bind(itemView)
        var img : ImageView

        init{
            img = view.findViewById(R.id.backdrop_poster)
        }

        fun setdata(data: Result){
            binding.tvTitleNowPlaying.text = data.title
            binding.tvReleased.text = data.release_date
            binding.cvNowplaying.setOnClickListener {
                val intent = Intent(it.context, Activity_Movie_Detail::class.java).putExtra("movieid",data.id)
                it.context.startActivity(intent)
            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_now_playing, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setdata(dataSet[position])
        Glide.with(viewHolder.itemView.context).load(Const.IMG_URL + dataSet[position].backdrop_path).into(viewHolder.img)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
