package com.example.consumodeappsuperhero.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("all.json")
    suspend fun getHeroes(): Response<List<SuperHero>>
}

class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        suspend fun instance(): WebService {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WebService::class.java)


        }
    }
}