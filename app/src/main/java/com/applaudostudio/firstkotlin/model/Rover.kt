package com.applaudostudio.firstkotlin.model

import com.google.gson.annotations.SerializedName

class Rover {
    /*
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("landing_date")
    private String mLanding_date;
    @SerializedName("launch_date")
    private String mLaunch_date;
    */
    @SerializedName("id")
    private var mId: String = ""
    @SerializedName("name")
    private var mName: String = ""
    @SerializedName("landing_date")
    private var mLanding_date: String = ""
    @SerializedName("launch_date")
    private var mLaunch_date: String = ""

}