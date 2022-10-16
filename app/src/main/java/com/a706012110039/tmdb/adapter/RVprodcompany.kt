package com.a706012110039.tmdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.tmdb.R
import com.a706012110039.tmdb.databinding.CardLogoBinding
import com.a706012110039.tmdb.helper.Const
import com.a706012110039.tmdb.model.ProductionCompany
import com.bumptech.glide.Glide

class RVprodcompany(private val dataSet: List<ProductionCompany>) :
        RecyclerView.Adapter<RVprodcompany.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img : ImageView
        val binding = CardLogoBinding.bind(itemView)

        fun setdata(data: ProductionCompany){
            binding.company.text = data.name
        }

        init{
            img = view.findViewById(R.id.imageView2)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_logo, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(!dataSet[position].logo_path.isNullOrBlank()){
            Glide.with(viewHolder.itemView.context).load(Const.IMG_URL + dataSet[position].logo_path).into(viewHolder.img)
        }
        viewHolder.setdata(dataSet[position])
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
