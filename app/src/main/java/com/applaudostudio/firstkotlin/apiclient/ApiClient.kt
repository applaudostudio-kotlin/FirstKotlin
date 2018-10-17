package com.applaudostudio.firstkotlin.apiclient

import com.applaudostudio.firstkotlin.model.JSONModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val apiClient: PhotosService
    private val mBaseUrl: String = "https://api.nasa.gov/mars-photos/api/v1/rovers/"
    private val API_KEY: String = "D4qaqQHftAk3mp7OkM7kbUArBzTiGaxEZymsHXHT";

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiClient = retrofit.create(PhotosService::class.java)
    }


    fun getAllPhotos(page: Int): Call<JSONModel> {
        return apiClient.getPhotos(50, page, API_KEY)
    }
}