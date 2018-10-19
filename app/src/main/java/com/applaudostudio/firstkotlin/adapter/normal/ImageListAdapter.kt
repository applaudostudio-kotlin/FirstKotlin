package com.applaudostudio.firstkotlin.adapter.normal

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import com.applaudostudio.firstkotlin.R
import com.applaudostudio.firstkotlin.glide.GlideApp
import com.applaudostudio.firstkotlin.model.Photos
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.imagenlist_card.view.*

     class ImageListAdapter(private var mDataSet: List<Photos>?) : RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder>() {
        lateinit var context: Context

        fun setData(mDataSet: List<Photos>) {
            this.mDataSet = mDataSet
            this.notifyDataSetChanged()
        }

        /***
         * Constructor for the view Holder of the recycler view
         * @param parent the parent viewGroup
         * @param viewType Type of view to be render
         * @return returns a RadioViewHolder
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
            context=parent.context
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.imagenlist_card, parent, false)
            return ImageListViewHolder(view)
        }

        override fun onBindViewHolder(imageListViewHolder: ImageListViewHolder, i: Int) {
            imageListViewHolder.bindData(mDataSet!![i])

        }

        override fun getItemCount(): Int {
            return mDataSet!!.size
        }



        /***
         * Class for the news View holder
         */
        inner class ImageListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindData(item: Photos) {
                GlideApp.with(itemView.context)
                        .load(item.mImg_src)
                        .fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .into(itemView.imgContntainer)
            }
        }


        companion object {
            val VIEW_TYPE_FULL = 2
            val VIEW_TYPE_GRID = 1
        }
    }


