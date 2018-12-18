package com.example.taetraining.starwarscharacters

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StarwarsServices {
    @GET("{user}")
    fun getUserDetails(@Path("user") id: String): Call<StarwarCharacter>
}