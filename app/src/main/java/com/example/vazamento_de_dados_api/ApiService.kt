package com.example.vazamento_de_dados_api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/public")
    fun checkEmail(@Query("check") email: String): Call<LeakResponse>
}
