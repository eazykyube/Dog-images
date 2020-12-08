package com.example.dogimages.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.dogimages.R
import com.example.dogimages.databinding.FragmentLookBinding
import kotlinx.android.synthetic.main.fragment_look.*

class LookFragment: Fragment() {

    lateinit var url: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentLookBinding.inflate(inflater)

        binding.backButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_lookFragment_to_viewFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        url = arguments?.getString("url").toString()
        Glide.with(view).load(url).into(look_image)
    }
}