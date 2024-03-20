package com.example.kotlin62.data.remote.models

import com.example.kotlin62.data.remote.apiServises.AnimeApiServises
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    object RetrofitClient {
        private const val BASE_URL = "https://kitsu.io/api/edge/"


        private val okHttpClient = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS).callTimeout(60L, TimeUnit.SECONDS).build()

        private val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()

        val mangaApiServise = retrofit.create(AnimeApiServises::class.java)
    }
}