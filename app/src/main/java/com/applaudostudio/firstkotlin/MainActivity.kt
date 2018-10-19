package com.applaudostudio.firstkotlin

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.applaudostudio.firstkotlin.fragment.ListFragment
import com.applaudostudio.firstkotlin.fragment.ListFragmentNormal
import com.applaudostudio.firstkotlin.util.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), ListFragment.OnFragmentInteractionListener, View.OnClickListener {

/*
lateinit var apiConfig: ApiClient
lateinit var resultList:MutableList<Photos>
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        button2.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        val fragmentList: ListFragment = ListFragment.newInstance("HOLA");
        when (p0) {
            button -> {
                val fragmentList: ListFragment = ListFragmentNormal.newInstance();
            }
            button2 ->{
                val fragmentList: ListFragment = ListFragment.newInstance("Abstract Adapter");
            }
        }
        this.replaceFragment(fragmentList, R.id.fragmentContainer)



    }


    /*
         apiConfig=ApiClient()
               resultList= mutableListOf()
               getListOfPhotos()
*/

/*
    fun getListOfPhotos(pPage:Int=1){
        val call = apiConfig.getAllPhotos(pPage)
        call.enqueue(object : Callback<JSONModel> {
            override fun onResponse(call: Call<JSONModel>, response: Response<JSONModel>) {
                if (response.body() != null) {
                    resultList.addAll(response.body()!!.mPhotos)
                    txtJSON.text = resultList[0].mImg_src


                    GlideApp.with(applicationContext)
                            .load(resultList[0].mImg_src)
                            .into(imageViewImg)

                }
            }

            override fun onFailure(call: Call<JSONModel>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }
*/


    override fun onFragmentInteraction() {
        toast("touched")
    }

}


