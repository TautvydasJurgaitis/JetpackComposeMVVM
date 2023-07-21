package com.z9.jur.jetpackcomposemvvm.network

import com.z9.jur.jetpackcomposemvvm.network.model.RecipeDto
import com.z9.jur.jetpackcomposemvvm.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("/api/recipe/search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse

    @GET("/api/recipe/get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeDto
}