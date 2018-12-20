package com.example.taetraining.starwarscharacters.SWRecyclerViewPackage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.taetraining.starwarscharacters.R
import com.example.taetraining.starwarscharacters.RV_URL
import kotlinx.android.synthetic.main.activity_second.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {

    private val adapter = RVadapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY



        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(RV_URL)
            .addConverterFactory(GsonConverterFactory.create())


        val retrofit = retrofitBuilder
            .client(okHttpClient)
            .build()


        val RVclient = retrofit.create(RVservices::class.java)

        rvFilms.layoutManager = LinearLayoutManager(this)
        rvFilms.adapter = adapter
        RVclient.getResults().enqueue(
                object : Callback<SWResults> {
                    override fun onFailure(call: Call<SWResults>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                    }
                    override fun onResponse(call: Call<SWResults>, result: Response<SWResults>) {

                        if (result.isSuccessful) {
                            adapter.setData(result.body()?.results ?: emptyList())

                        }

                    }



                }

            )

        }

    }

