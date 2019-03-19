package com.guyverhopkins.searchresults.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultResponse


/**
 * created by ghopkins 3/19/2019.
 */
class SearchReusltAdapter :
    PagedListAdapter<SearchResultResponse, SearchReusltAdapter.SearchResultViewHolder>(SearchResultDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_search_result, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.tvLink.paintFlags = holder.tvLink.paintFlags or Paint.UNDERLINE_TEXT_FLAG
//        Picasso.with(holder.ivImage.context).load("testurl").into(holder.ivImage as ImageView)
    }


    inner class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvLink: TextView = itemView.findViewById(R.id.tv_link_search_result_item)
        var tvUrl: TextView = itemView.findViewById(R.id.tv_url_search_result_item)
        var ivImage: TextView = itemView.findViewById(R.id.iv_search_result_item)
        var tvDescripion: TextView = itemView.findViewById(R.id.tv_description_search_result_item)
    }
}

class SearchResultDiffCallback : DiffUtil.ItemCallback<SearchResultResponse>() {
    override fun areContentsTheSame(oldItem: SearchResultResponse, newItem: SearchResultResponse): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: SearchResultResponse, newItem: SearchResultResponse): Boolean {
        return oldItem.id == newItem.id
    }
}