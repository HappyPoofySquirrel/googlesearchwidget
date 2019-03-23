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
        this.view = null
        if (isLoading) {
            googleSearcher.cancel()
            view?.hideLoading()
        }
    }

    override fun onNextPage() {
        executeQuery()
    }

    fun executeQuery() { //lets keep this public so we can test it
        isLoading = true
        view?.showLoading()

        googleSearcher.search(searchString, currentPage, getRemainingResultCountToRequest(), this)
    }

    fun getRemainingResultCountToRequest(): Int { //lets keep this public so we can test it
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
        view?.hideLoading()
        view?.showMessage(R.string.error_search_results)
    }
}
