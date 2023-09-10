package com.floxy.crudnative.repository

import com.floxy.crudnative.models.QuotesModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuotesAPI {

    @Headers("X-Api-Key:ehUmGIiPNkhcl1tv6dKyDg==uANnhf3NobousAbn")
    @GET("v1/quotes?category=happiness")
    suspend fun getQuotes(): List<QuotesModel>

}