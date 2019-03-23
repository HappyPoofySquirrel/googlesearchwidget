package com.guyverhopkins.searchresults.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.fromHtml
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem
import com.squareup.picasso.Picasso


/**
 * created by ghopkins 3/19/2019.
 */
class SearchResultAdapter(private val loadMoreListener: LoadMoreButtonListener) :
    RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    private var searchResults: MutableList<SearchResultItem> = mutableListOf()

    private var isLoading: Boolean = true

    private var shouldShowMoreResultsButton: Boolean = true

    override fun getItemCount(): Int {
        return searchResults.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(
            if (searchResults.size > 0 && viewType == R.layout.list_item_search_result) { //todo try removing the size check
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_search_result, parent, false
                )
            } else {
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_search_result_footer, parent, false
                )
            }
        )
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        if (position == searchResults.size) {
            holder.btnLoadMore!!.setOnClickListener {
                loadMoreListener.onLoadMorePressed()
            }

            if (shouldShowMoreResultsButton) {
                if (isLoading) {
                    holder.pbLoading!!.visibility = View.VISIBLE
                    holder.btnLoadMore!!.visibility = View.GONE
                } else {
                    holder.pbLoading!!.visibility = View.GONE
                    holder.btnLoadMore!!.visibility = View.VISIBLE
                }
            } else {
                holder.pbLoading!!.visibility = View.GONE
                holder.btnLoadMore!!.visibility = View.GONE
            }
        } else {
            val item = searchResults[position]
            holder.tvTitle!!.paintFlags = holder.tvTitle!!.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            holder.tvTitle!!.text = item.htmlTitle.fromHtml()
            holder.tvUrl!!.text = item.htmlFormattedUrl.fromHtml()
            holder.tvDescripion!!.text = item.htmlSnippet.fromHtml()
            item.pagemap.cseThumbnail.let {
                holder.ivImage!!.visibility = View.VISIBLE
                Picasso.with(holder.ivImage!!.context).load(it[0].src).into(holder.ivImage)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == searchResults.size) {
            R.layout.list_item_search_result_footer
        } else { //todo setup video result layout
            R.layout.list_item_search_result
        }
    }

    fun setItems(searchResults: MutableList<SearchResultItem>) {
        this.searchResults = searchResults
    }

    fun showLoading() {
        isLoading = true
    }

    fun hideLoading() {
        isLoading = false
    }

    fun hideShowMoreButton() {
        shouldShowMoreResultsButton = false
    }

    inner class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView? = itemView.findViewById(R.id.tv_title_search_result_item)
        var tvUrl: TextView? = itemView.findViewById(R.id.tv_url_search_result_item)
        var ivImage: ImageView? = itemView.findViewById(R.id.iv_search_result_item)
        var tvDescripion: TextView? = itemView.findViewById(R.id.tv_description_search_result_item)

        var pbLoading: ProgressBar? = itemView.findViewById(R.id.pb_search_results)
        var btnLoadMore: Button? = itemView.findViewById(R.id.btn_search_results_load_more)
    }
}

interface LoadMoreButtonListener {
    fun onLoadMorePressed()
}