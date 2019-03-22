package com.guyverhopkins.searchresults.ui

import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.googlesearch.IGoogleSearcher
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultResponse
import com.guyverhopkins.searchresults.core.networking.NetworkError

class SearchResultPresenter(private val googleSearcher: IGoogleSearcher, private val searchString: String) :
    ISearchResultContract.Presenter,
    IGoogleSearcher.Listener {

    private var currentPage: Int = 0

    private var isLoading: Boolean = false

    private var endOfList: Boolean = false

    private var searchResults: MutableList<SearchResultItem> = mutableListOf()

    private var view: ISearchResultContract.View? = null

    override fun attachView(view: ISearchResultContract.View) {
        this.view = view

        if (searchResults.isNotEmpty()) {
            view.hideLoading()
            view.setSearchResults(searchResults)
        } else {
            executeQuery()
        }

    }

    override fun detachView() {
        this.view = null
        if (isLoading) {
            googleSearcher.cancel()
            view?.hideLoading()
        }
    }

    override fun onNextPage() {
        if (!endOfList) {
            if (!isLoading) { //do not remove this check as onScrollListener is called twice because the item range changes therefore calling the listener again
                currentPage++
                executeQuery()
            }
        } else {
            view?.hideLoading()
        }
    }

    private fun executeQuery() {
        isLoading = true
        view?.showLoading()

        googleSearcher.search(searchString, currentPage, this)
    }

    override fun onGetSearchResult(searchResultResponse: SearchResultResponse) {
        if (searchResultResponse.items.isEmpty()) {
            endOfList = true
        } else {
            searchResults.addAll(searchResultResponse.items)
            currentPage = searchResultResponse.queries.nextPage[0].startIndex - 1 //todo may need to rid of -1
            view?.setSearchResults(searchResults)
        }


        isLoading = false
        view?.hideLoading()
    }

    override fun onGetSearchResultError(networkError: NetworkError) {
        isLoading = false
        view?.hideLoading()
        view?.showMessage(R.string.error_search_results)
    }
}
