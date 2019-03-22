package com.guyverhopkins.searchresults.core

import com.guyverhopkins.searchresults.core.googlesearch.SearchResultResponse

interface ISearchResultRepository {

    fun getSearchResults(): SearchResultResponse?

}
