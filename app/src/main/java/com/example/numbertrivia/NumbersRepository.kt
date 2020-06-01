package com.example.numbertrivia

class NumbersRepository {
    private val numbersApi: NumbersApiService = NumbersApi.createApi()

    fun getRandomNumberTrivia() = numbersApi.getRandomNumberTrivia()
}