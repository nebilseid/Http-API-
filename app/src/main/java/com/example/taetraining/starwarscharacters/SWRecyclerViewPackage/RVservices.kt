package com.example.taetraining.starwarscharacters.SWRecyclerViewPackage

import com.example.taetraining.starwarscharacters.RV_URL
import retrofit2.Call
import retrofit2.http.GET

interface RVservices {

    @GET(RV_URL)

    fun getResults(): Call<SWResults>
}