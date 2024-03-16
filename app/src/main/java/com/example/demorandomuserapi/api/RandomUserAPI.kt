package com.example.demorandomuserapi.api

import com.example.demorandomuserapi.model.RandomUserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserAPI {
    @GET("/api")
    suspend fun getRandomUserData(
        @Query("results") results: Int,
    ): Response<RandomUserData>
}