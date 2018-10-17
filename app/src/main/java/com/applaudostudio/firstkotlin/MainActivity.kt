package com.applaudostudio.firstkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.applaudostudio.firstkotlin.apiclient.ApiClient
import com.applaudostudio.firstkotlin.model.JSONModel
import com.applaudostudio.firstkotlin.model.Photos
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var apiConfig: ApiClient
    lateinit var resultList:MutableList<Photos>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiConfig=ApiClient()
        resultList= mutableListOf()
        getListOfPhotos()
    }

    fun getListOfPhotos(pPage:Int=1){
        val call = apiConfig.getAllPhotos(pPage)
        call.enqueue(object : Callback<JSONModel> {
            override fun onResponse(call: Call<JSONModel>, response: Response<JSONModel>) {
                if (response.body() != null) {
                    resultList.addAll(response.body()!!.mPhotos)
                    txtJSON.text = resultList[0].mImg_src
                }
            }

            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }


}
