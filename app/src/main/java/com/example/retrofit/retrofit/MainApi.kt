package com.example.retrofit.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {
    @GET("auth/recipes/{id}")
    suspend fun getRecipesById(@Path("id") id: Int): Recipes

    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): Response<User>

    @Headers("Content-Type: application/json")
    @GET("auth/recipes")
    suspend fun getAllRecipes(@Header("Authorization") token: String): Recipe

    @Headers("Content-Type: application/json")
    @GET("auth/recipes/search")
    suspend fun getRecipesByNameAuth(
        @Header("Authorization") token: String,
        @Query("q") name: String
    ): Recipe
}