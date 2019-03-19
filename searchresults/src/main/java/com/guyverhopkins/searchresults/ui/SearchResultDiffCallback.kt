package com.guyverhopkins.searchresults.ui

/**
 * created by ghopkins 3/19/2019.
 */
import androidx.recyclerview.widget.DiffUtil
import com.guyverhopkins.searchresults.core.SearchResultResponse

class SearchResultDiffCallback : DiffUtil.ItemCallback<SearchResultResponse>() {
    override fun areContentsTheSame(oldItem: SearchResultResponse, newItem: SearchResultResponse): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: SearchResultResponse, newItem: SearchResultResponse): Boolean {
        return oldItem.id == newItem.id
    }
}