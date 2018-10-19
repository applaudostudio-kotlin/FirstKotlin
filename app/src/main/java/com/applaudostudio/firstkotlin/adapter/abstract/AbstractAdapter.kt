package com.applaudostudio.firstkotlin.adapter.abstract

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractAdapter<ITEM> constructor(
        private var itemList: List<ITEM>,
        private val layoutResId: Int)
    : RecyclerView.Adapter<AbstractAdapter.Holder>() {

    protected abstract fun onItemClick(itemView: View, position: Int)

    protected abstract fun View.bind(item: ITEM)

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick(itemView, position)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}






