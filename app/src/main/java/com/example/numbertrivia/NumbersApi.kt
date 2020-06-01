package com.example.numbertrivia

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NumbersApi {
    companion object {
        const val baseUrl = "http://numbersapi.com/"

        /**
         * @return [NumbersApiService] The service class off the retrofit client.
         */
        fun createApi(): NumbersApiService {
            //Create an OkHttpClientto make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // retrofit instance
            val numbersApi = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return numbersApi.create(NumbersApiService::class.java)
        }

    }
}