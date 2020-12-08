package com.example.dogimages.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogimages.databinding.FragmentViewBinding
import com.example.dogimages.network.Dog
import com.example.dogimages.network.DogAdapter
import com.example.dogimages.network.DogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewFragment: Fragment() {

    lateinit var dogApi: DogApi

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentViewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        dogApi = DogApi()

        val layoutManager = GridLayoutManager(context, 2)
        val adapter = DogAdapter()

        binding.photosGrid.adapter = adapter
        binding.photosGrid.layoutManager = layoutManager
        binding.photosGrid.itemAnimator = DefaultItemAnimator()

        binding.searchButton.setOnClickListener {
            val breed = binding.searchEdit.text.toString()
            if (!breed.isNullOrBlank()) {
                dogApi.dogService.getAllByBreed(breed.toLowerCase())
                    .enqueue(object : Callback<Dog> {
                        override fun onFailure(call: Call<Dog>, t: Throwable) {
                            Toast.makeText(context,
                                "Failure", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Dog>, response: Response<Dog>) {
                            adapter.submitList(response.body()?.links)
                        }
                    })
            }
        }
        return binding.root
    }
}