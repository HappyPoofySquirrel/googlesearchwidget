package com.guyverhopkins.searchresults.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.googlesearch.GoogleSearcherFactory
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem


/**
 * created by ghopkins 3/19/2019.
 */
class SearchResultLayout : LinearLayout, ISearchResultContract.View, LoadMoreButtonListener {

    private lateinit var rvSearchResults: RecyclerView

    private lateinit var presenter: ISearchResultContract.Presenter

    private var listener: SearchResultErrorMessageListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.search_result, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchResult)
        val maxResultCount = typedArray.getInt(R.styleable.SearchResult_max_search_results, 5)
        val searchString = typedArray.getString(R.styleable.SearchResult_search_result_search_string)
        typedArray.recycle()

        val googleSearcher = GoogleSearcherFactory.build(context)

        rvSearchResults = view.findViewById(R.id.rv_search_results)

        val adapter = SearchResultAdapter(this)
        rvSearchResults.adapter = adapter
        presenter = SearchResultPresenter(googleSearcher, searchString, maxResultCount)
    }

    override fun hideLoading() {
        val adapter = rvSearchResults.adapter as SearchResultAdapter
        adapter.hideLoading() //todo this is not working if the request errors out
        adapter.notifyItemChanged(adapter.itemCount)
    }

    override fun showLoading() {
        val adapter = rvSearchResults.adapter as SearchResultAdapter
        adapter.showLoading()
        adapter.notifyItemChanged(adapter.itemCount)
    }

    override fun showMessage(resourceId: Int) {
        listener?.onError(context.getString(resourceId))
    }

    override fun hideShowMoreButton() {
        val adapter = rvSearchResults.adapter as SearchResultAdapter
        adapter.hideShowMoreButton()
        adapter.notifyItemChanged(adapter.itemCount)
    }

    override fun scrollToTop() {
        rvSearchResults.scrollToPosition(0)
    }

    override fun setSearchResults(searchResults: MutableList<SearchResultItem>) {
        val adapter = rvSearchResults.adapter as SearchResultAdapter
        val startIndex2 = adapter.itemCount - 1

        adapter.setItems(searchResults)
        adapter.notifyItemRangeInserted(startIndex2, searchResults.size - 1)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.attachView(this)
    }

    override fun onLoadMorePressed() {
        presenter.onNextPage()
    }

    fun attachListener(listener: SearchResultErrorMessageListener) {
        this.listener = listener
    }
}

interface SearchResultErrorMessageListener {
    fun onError(message: String)
}

