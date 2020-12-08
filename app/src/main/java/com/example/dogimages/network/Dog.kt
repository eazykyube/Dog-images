package com.example.dogimages.network

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("message")
    var links: List<String>,
    @SerializedName("status")
    var status: String
) {

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<String> = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}