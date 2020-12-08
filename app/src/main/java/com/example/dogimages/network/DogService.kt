package com.example.dogimages.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("api/breed/{breed}/images")
    fun getAllByBreed(@Path("breed") breed: String): Call<Dog>
}