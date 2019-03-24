package com.guyverhopkins.searchresults.ui

import com.guyverhopkins.searchresults.R
import com.guyverhopkins.searchresults.core.googlesearch.IGoogleSearcher
import com.guyverhopkins.searchresults.core.networking.NetworkError
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * created by ghopkins 3/24/2019.
 */
class SearchResultPresenterTest {
    private val view = mock(ISearchResultContract.View::class.java)

    private lateinit var presenter: ISearchResultContract.Presenter

    private val googleSearcher = mock(IGoogleSearcher::class.java)

    private val searchString = "test"

    private val resultCount = 12

    @Before
    fun setUp() {
        presenter = SearchResultPresenter(googleSearcher, searchString, resultCount)
    }

    @Test
    fun searchesOnAttach() {
        presenter = SearchResultPresenter(googleSearcher, searchString, 2)
        presenter.attachView(view)
        verify(view).showLoading()
        verify(googleSearcher).search(searchString, 1, 2, presenter as IGoogleSearcher.Listener)
    }

    @Test
    fun cancelsIfLoadingOnDetach() {
        presenter.attachView(view)
        presenter.detachView()
        verify(googleSearcher).cancel()
        verify(view).hideLoading()
    }

    @Test
    fun onNextPage() {
        presenter.attachView(view)
        presenter.onNextPage()
        verify(view, times(2)).showLoading() //once in on attach
        verify(googleSearcher, times(2)).search( //once in on attach
            searchString,
            1,
            10,
            presenter as IGoogleSearcher.Listener
        ) //10 is the max number we can have
    }

    @Test
    fun onSearchFailed() {
        presenter.attachView(view)
        (presenter as IGoogleSearcher.Listener).onGetSearchResultError(NetworkError())
        verify(view).hideLoading()
        verify(view).hideShowMoreButton()
        verify(view).showMessage(R.string.error_search_results)
    }
}