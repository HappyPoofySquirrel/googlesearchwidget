package com.guyverhopkins.searchresults.core

import com.guyverhopkins.searchresults.core.googlesearch.IGoogleSearcher
import com.guyverhopkins.searchresults.core.googlesearch.SearchResultResponse

/**
 * created by ghopkins 3/19/2019.
 */
class SearchResultRepository(private val googleSearcher: IGoogleSearcher) : ISearchResultRepository {


    override fun getSearchResults(): SearchResultResponse? {
        return null
    }

}