package com.sameer.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface APIinterface {
    @GET("api/v1/questions?apiKey=9P9oLKLUsLDhRbKSiGQjLAx5OBMzZMaRzu4fsxHW&limit=10")
    fun getproductData() : Call<MyData>
}