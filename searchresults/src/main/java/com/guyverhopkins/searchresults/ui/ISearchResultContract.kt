package com.guyverhopkins.searchresults.ui

import com.guyverhopkins.searchresults.core.googlesearch.SearchResultItem

interface ISearchResultContract {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun setSearchResults(
            searchResults: MutableList<SearchResultItem>
        )

        fun showMessage(resourceId: Int)
        fun hideShowMoreButton()
        fun scrollToTop()
    }

    interface Presenter {
        fun attachView(view: View)
        fun onNextPage()
        fun detachView()
    }
}
