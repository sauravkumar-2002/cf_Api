package com.example.cf_prob.Services_and_interface

import com.example.cf_prob.Model_classes.ret_obj
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface interface_1 {
    @GET("problemset.problems")
    fun getDestinationList(): Call<ret_obj>

    companion object service {
        val URL = "https://codeforces.com/api/"

        var retrofitService: interface_1? = null
        fun getInstance(): interface_1 {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(interface_1::class.java)
            }
            return retrofitService!!
        }


    }

}