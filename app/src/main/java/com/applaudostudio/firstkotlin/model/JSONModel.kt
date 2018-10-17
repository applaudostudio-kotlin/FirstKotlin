package com.applaudostudio.firstkotlin.model

import com.google.gson.annotations.SerializedName

class JSONModel {
    /*
    private List<Photos> mPhotosList;

    */
    @SerializedName("photos")
    var mPhotos:MutableList<Photos> = mutableListOf()
}