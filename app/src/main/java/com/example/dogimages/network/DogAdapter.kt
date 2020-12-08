package com.example.dogimages.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogimages.R
import kotlinx.android.synthetic.main.image_view.view.*

class DogAdapter : ListAdapter<String, PesikiViewHolder>(Dog.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesikiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_view, parent,false)
        return PesikiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PesikiViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PesikiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var bundle: Bundle

    fun bind(link: String) {
        Glide.with(itemView).load(link).into(itemView.dog_image)
        itemView.setOnClickListener {
            bundle = Bundle()
            bundle.putString("url", link)

            it.findNavController().navigate(R.id.action_viewFragment_to_lookFragment, bundle)
        }
    }
}