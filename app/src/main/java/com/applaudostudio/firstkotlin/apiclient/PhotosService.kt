package com.applaudostudio.firstkotlin.apiclient

import com.applaudostudio.firstkotlin.model.JSONModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosService {

    //?sol={sol}&page={page}&api_key={key}
    @GET("curiosity/photos")
    fun getPhotos(@Query("sol") sol: Int,
                  @Query("page") page: Int,
                  @Query("api_key") api_key: String)
            : Call<JSONModel>
}