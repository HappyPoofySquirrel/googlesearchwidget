package com.guyverhopkins.searchresults.core.googlesearch

import com.guyverhopkins.searchresults.core.networking.NetworkError

interface IGoogleSearcher {

    interface Listener {
        fun onGetSearchResult(searchResultResponse: SearchResultResponse)
        fun onGetSearchResultError(networkError: NetworkError)
    }

    fun cancel()

    fun search()
}
