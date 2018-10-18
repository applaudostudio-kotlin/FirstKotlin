package com.applaudostudio.firstkotlin

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.applaudostudio.firstkotlin.fragment.ListFragment
import com.applaudostudio.firstkotlin.util.replaceFragment


class MainActivity : AppCompatActivity(), ListFragment.OnFragmentInteractionListener {

/*
lateinit var apiConfig: ApiClient
lateinit var resultList:MutableList<Photos>
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentList: ListFragment = ListFragment.newInstance("HOLA");
        this.replaceFragment(fragmentList,R.id.fragmentContainer)



        /*
        apiConfig=ApiClient()
              resultList= mutableListOf()
              getListOfPhotos()
          */


    }




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


    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


