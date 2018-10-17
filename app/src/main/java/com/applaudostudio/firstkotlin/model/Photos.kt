package com.applaudostudio.firstkotlin.model

import com.google.gson.annotations.SerializedName

class Photos {
    /*
    @SerializedName("id")
    private int mId;
    @SerializedName("sol")
    private int mSol;
    @SerializedName("camera")
    private Camera mCamera;
    @SerializedName("img_src")
    private String mImg_src;
    @SerializedName("earth_date")
    private String mEarth_date;
    @SerializedName("rover")
    private Rover mRover;
    */
    @SerializedName("id")
    var mId: Int = 0
    @SerializedName("sol")
    var mSol: Int = 0
    @SerializedName("camera")
    var mCamera: Camera? = null
    @SerializedName("img_src")
    var mImg_src: String = ""
    @SerializedName("earth_date")
    var mEarth_date: String = ""
    @SerializedName("rover")
    var mRover: Rover? = null


}