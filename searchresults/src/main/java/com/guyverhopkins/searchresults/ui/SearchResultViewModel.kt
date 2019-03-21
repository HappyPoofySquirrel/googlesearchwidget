package com.guyverhopkins.searchresults.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guyverhopkins.searchresults.core.googlesearch.IGoogleSearcher

class SearchResultViewModel(private val googleSearcher: IGoogleSearcher) : ViewModel()

class SearchResultViewModelFactory(private val googleSearcher: IGoogleSearcher) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SearchResultViewModel::class.java)) {
            SearchResultViewModel(googleSearcher) as T
        } else {
            throw IllegalArgumentException("Edit ViewModel Not Found")
        }
    }
}