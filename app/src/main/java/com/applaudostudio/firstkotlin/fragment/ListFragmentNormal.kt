package com.applaudostudio.firstkotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.applaudostudio.firstkotlin.R
import com.applaudostudio.firstkotlin.adapter.abstract.setUp
import com.applaudostudio.firstkotlin.adapter.normal.ImageListAdapter
import com.applaudostudio.firstkotlin.apiclient.ApiClient
import com.applaudostudio.firstkotlin.glide.GlideApp
import com.applaudostudio.firstkotlin.model.JSONModel
import com.applaudostudio.firstkotlin.model.Photos
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.imagenlist_card.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"


class ListFragmentNormal : Fragment() {
    var apiConfig: ApiClient = ApiClient()
    var resultList: MutableList<Photos> = mutableListOf()
     var normalAdapter:ImageListAdapter= ImageListAdapter(mutableListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        normalAdapter.setData(mutableListOf())
        recyclerViewImages.adapter=normalAdapter

    }


    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    fun LoadList(pPage: Int = 1) {
        val call = apiConfig.getAllPhotos(pPage)

        call.enqueue(object : Callback<JSONModel> {

            override fun onResponse(call: Call<JSONModel>, response: Response<JSONModel>) {
                if (response.body() != null) {

                    resultList.addAll(response.body()!!.mPhotos)
                    normalAdapter.setData(resultList)
                    normalAdapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }
}
