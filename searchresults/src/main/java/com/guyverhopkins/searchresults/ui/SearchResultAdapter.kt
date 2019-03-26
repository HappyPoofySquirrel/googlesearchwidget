package com.guyverhopkins.searchresults.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.common.formatDatePosted
import com.guyverhopkins.searchresults.core.common.fromHtml
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem
import com.squareup.picasso.Picasso


/**
 * created by ghopkins 3/19/2019.
 */
class SearchResultAdapter(private val loadMoreListener: LoadMoreButtonListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var searchResults: MutableList<SearchResultItem> = mutableListOf()

    private var isLoading: Boolean = true

    private var shouldShowMoreResultsButton: Boolean = true

    override fun getItemCount(): Int {
        return searchResults.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.list_item_search_result -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_search_result, parent, false
                )
                SearchResultViewHolder(view)
            }
            R.layout.list_item_search_result_footer -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_search_result_footer, parent, false
                )
                SearchResultViewHolderFooter(view)
            }
            R.layout.list_item_search_result_video -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_search_result_video, parent, false
                )
                SearchResultViewHolderVideo(view)
            }
            else -> throw IllegalAccessException("Invalid view")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchResultViewHolderFooter -> {
                holder.btnLoadMore.setOnClickListener {
                    loadMoreListener.onLoadMorePressed()
                }

                if (shouldShowMoreResultsButton) {
                    if (isLoading) {
                        holder.pbLoading.visibility = View.VISIBLE
                        holder.btnLoadMore.visibility = View.GONE
                    } else {
                        holder.pbLoading.visibility = View.GONE
                        holder.btnLoadMore.visibility = View.VISIBLE
                    }
                } else {
                    holder.pbLoading.visibility = View.GONE
                    holder.btnLoadMore.visibility = View.GONE
                }
            }
            is SearchResultViewHolder -> {
                val item = searchResults[position]
                holder.tvTitle.paintFlags = holder.tvTitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                holder.tvTitle.text = item.htmlTitle.fromHtml()
                holder.tvUrl.text = item.htmlFormattedUrl.fromHtml()
                holder.tvDescripion.text = item.htmlSnippet.fromHtml()
                item.pagemap.cseThumbnail?.let {
                    holder.cvImageContainer.visibility = View.VISIBLE
                    Picasso.with(holder.ivImage.context).load(it[0].src).fit().into(holder.ivImage)
                }
            }

            is SearchResultViewHolderVideo -> {
                val item = searchResults[position]
                holder.tvTitle.paintFlags = holder.tvTitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                holder.tvTitle.text = item.htmlTitle.fromHtml()
                holder.tvUrl.text = item.htmlFormattedUrl.fromHtml()
                holder.tvUloadedBy.text = item.pagemap.metatags[0].ogVideoTag //this may not be the uploader

                item.pagemap.videoobject?.let {
                    holder.tvDatePosted.text =
                        it[0].datepublished.formatDatePosted() //we should always have a video object if we get here.
                    Picasso.with(holder.ivImage.context).load(it[0].thumbnailurl).into(holder.ivImage)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position == searchResults.size -> R.layout.list_item_search_result_footer
            searchResults[position].pagemap.videoobject != null -> R.layout.list_item_search_result_video //sometimes article types have this object with no thumbnail or date posted. Detect if video from different property
            else -> R.layout.list_item_search_result
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
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title_search_result_item)
        var tvUrl: TextView = itemView.findViewById(R.id.tv_url_search_result_item)
        var ivImage: ImageView = itemView.findViewById(R.id.iv_search_result_item)
        var tvDescripion: TextView = itemView.findViewById(R.id.tv_description_search_result_item)
        var cvImageContainer: CardView = itemView.findViewById(R.id.cv_search_result_image_container_item)
    }

    inner class SearchResultViewHolderFooter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pbLoading: ProgressBar = itemView.findViewById(R.id.pb_search_results)
        var btnLoadMore: Button = itemView.findViewById(R.id.btn_search_results_load_more)
    }

    inner class SearchResultViewHolderVideo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title_search_result_video_item)
        var tvUrl: TextView = itemView.findViewById(R.id.tv_url_search_result_video_item)
        var ivImage: ImageView = itemView.findViewById(R.id.iv_search_result_video_item)
        var tvUloadedBy: TextView = itemView.findViewById(R.id.tv_search_result_video_item_uploaded_value)
        var tvDatePosted: TextView = itemView.findViewById(R.id.tv_search_result_video_item_posted_value)
    }
}

interface LoadMoreButtonListener {
    fun onLoadMorePressed()
}