package com.floxy.crudnative.networks

import com.floxy.crudnative.repository.QuotesAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuotesNetwork {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuotesAPI::class.java)
    }
}