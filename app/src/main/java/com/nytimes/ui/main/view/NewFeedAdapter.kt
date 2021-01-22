package com.nytimes.ui.main.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nytimes.R
import com.nytimes.data.model.NewFeed

/**
* Created by sameer.khader on 23/01/2021.
*/
class NewFeedAdapter(private val nContext: Context, private val newFeeds: ArrayList<NewFeed>) :
    RecyclerView.Adapter<NewFeedAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
        val ivMedia: ImageView = view.findViewById(R.id.iv_media)
        val ivMore: ImageView = view.findViewById(R.id.iv_more)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_new_feed, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val newFeed = newFeeds[position]
        viewHolder.tvTitle.text = newFeed.title
        if (!newFeed.abstract.isNullOrBlank())
            viewHolder.tvDescription.text = newFeed.abstract
        else
            viewHolder.tvDescription.text = newFeed.title
        if (!newFeed.media.isNullOrEmpty() && !newFeed.media[0].mediaMetadata.isNullOrEmpty()) {
            val mediaList = newFeed.media[0].mediaMetadata
            Glide.with(nContext).load(mediaList[0].url).into(viewHolder.ivMedia)
            if (mediaList.size == 3)
                Glide.with(nContext).load(mediaList[2].url).into(viewHolder.ivMedia)
        } else if (!newFeed.multimedia.isNullOrEmpty()) {
            Glide.with(nContext).load(newFeed.multimedia[0].url).into(viewHolder.ivMedia)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = newFeeds.size

}