package com.applaudostudio.firstkotlin.model

import com.google.gson.annotations.SerializedName

class Camera {
    /*
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("rover_id")
    private String mRover_id;
    @SerializedName("full_name")
    private String mFull_Name;*/
    @SerializedName("id")
    var mId: Int = 0
    @SerializedName("name")
    var mName: String = ""
    @SerializedName("rover_id")
    var mRover: String = ""
    @SerializedName("full_name")
    var mFull_Name: String = ""

}