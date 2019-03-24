package com.guyverhopkins.searchresults.ui

import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.googlesearch.IGoogleSearcher
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultResponse
import com.guyverhopkins.searchresults.core.networking.NetworkError

class SearchResultPresenter(
    private val googleSearcher: IGoogleSearcher,
    private val searchString: String,
    private val maxResultCount: Int
) :
    ISearchResultContract.Presenter,
    IGoogleSearcher.Listener {

    private var currentPage: Int = 1 //google custom search start with an index of 1

    private var isLoading: Boolean = false

    private var searchResults: MutableList<SearchResultItem> = mutableListOf()

    private var view: ISearchResultContract.View? = null

    override fun attachView(view: ISearchResultContract.View) {
        this.view = view
        executeQuery()
    }

    override fun detachView() {
        if (isLoading) {
            googleSearcher.cancel()
            view?.hideLoading()
        }
        this.view = null
    }

    override fun onNextPage() {
        executeQuery()
    }

    private fun executeQuery() {
        isLoading = true
        view?.showLoading()

        googleSearcher.search(searchString, currentPage, getRemainingResultCountToRequest(), this)
    }

    private fun getRemainingResultCountToRequest(): Int { //10 is the max results that can be returned
        val count = maxResultCount - searchResults.count()
        return if (count >= 10) {
            10
        } else {
            count
        }
    }

    override fun onGetSearchResult(searchResultResponse: SearchResultResponse) {
        searchResults.addAll(searchResultResponse.items)
        if (searchResults.size <= 10) { //on first result start at the top
            view?.scrollToTop()
        }
        currentPage = searchResultResponse.queries.nextPage[0].startIndex
        view?.setSearchResults(searchResults)

        isLoading = false
        view?.hideLoading()

        if (getRemainingResultCountToRequest() == 0) {
            view?.hideShowMoreButton()
        }
    }

    override fun onGetSearchResultError(networkError: NetworkError) {
        isLoading = false
        view?.let {
            it.hideLoading()
            it.hideShowMoreButton()
            it.showMessage(R.string.error_search_results)
        }
    }
}
