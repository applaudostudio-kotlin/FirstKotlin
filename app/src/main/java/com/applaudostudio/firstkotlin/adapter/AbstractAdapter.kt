package com.applaudostudio.firstkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class AbstractAdapter {
    abstract class AbstractAdapter<ITEM> constructor(
            protected var itemList: List<ITEM>,
            private val layoutResId: Int)
        : RecyclerView.Adapter<AbstractAdapter.Holder>() {

        class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}