package com.a706012110039.tmdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.tmdb.R
import com.a706012110039.tmdb.databinding.CardGenreBinding
import com.a706012110039.tmdb.model.SpokenLanguage

class RVSpokenLanguange(private val dataSet: List<SpokenLanguage>) :
        RecyclerView.Adapter<RVSpokenLanguange.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardGenreBinding.bind(itemView)

        fun setdata(data: SpokenLanguage){
            binding.textView.text = data.name
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_genre, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.setdata(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
