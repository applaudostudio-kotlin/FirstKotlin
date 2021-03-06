package com.applaudostudio.firstkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applaudostudio.firstkotlin.R
import com.applaudostudio.firstkotlin.adapter.abstract.setUp
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


class ListFragment : Fragment() {
    lateinit var apiConfig: ApiClient
    lateinit var resultList: MutableList<Photos>
    private var param1: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { param1 = it.getString(ARG_PARAM1) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        resultList= mutableListOf()
        apiConfig=ApiClient()
        LoadList()
/*

*/
    }

    fun onButtonPressed() {
        listener?.onFragmentInteraction()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
                ListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }


    }
    fun LoadList(pPage: Int = 1) {
        val call = apiConfig.getAllPhotos(pPage)

        call.enqueue(object : Callback<JSONModel> {

            override fun onResponse(call: Call<JSONModel>, response: Response<JSONModel>) {
                if (response.body() != null) {

                    resultList.addAll(response.body()!!.mPhotos)


                    recyclerViewImages.setUp(resultList, R.layout.imagenlist_card, {
                        GlideApp.with(context)
                                .load(it.mImg_src)
                                .into(imgContntainer)
                    }, {
                        onButtonPressed()
                    })

                }
            }

            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }
}
