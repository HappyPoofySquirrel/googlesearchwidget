package com.guyverhopkins.searchresults.core.googlesearch

import android.content.Context
import com.guyverhopkins.searchresults.BuildConfig
import com.guyverhopkins.searchresults.core.networking.INetworkManager
import com.guyverhopkins.searchresults.core.networking.NetworkError
import com.guyverhopkins.searchresults.core.networking.NetworkManager
import com.guyverhopkins.searchresults.core.networking.RequestBuilder
import com.guyverhopkins.searchresults.core.networking.logging.ClientProvider
import com.guyverhopkins.searchresults.core.networking.logging.CurlLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * created by ghopkins 3/19/2019.
 */
private class GoogleSearcher(private val networkManager: NetworkManager, private val requestBuilder: RequestBuilder) :
    IGoogleSearcher, INetworkManager.NetworkCallback {

    private var call: Call<SearchResultResponse>? = null
    private lateinit var listener: IGoogleSearcher.Listener

    override fun search(
        searchTerm: String,
        page: Int,
        listener: IGoogleSearcher.Listener
    ) {
        this.listener = listener
        val service = requestBuilder.build(Service::class.java)
        call = service.get(
            searchTerm,
            BuildConfig.GOOGLE_SEARCH_ENGINE_ID,
            BuildConfig.GOOGLE_SEARCH_API_KEY
        )
        networkManager.enqueueCall(call as Call<SearchResultResponse>, this)
    }

    override fun cancel() {
        call?.cancel()
    }

    override fun onResponse(response: Response<*>) {
        val resultResponse = response.body() as SearchResultResponse
        listener.onGetSearchResult(resultResponse)
    }

    override fun onFailure(networkError: NetworkError) {
        listener.onGetSearchResultError(networkError)
    }

    interface Service {
        @GET("customsearch/v1")
        fun get(
            @Query("q") searchTerm: String,
            @Query("cx") searchEngineId: String,
            @Query("key") apiKey: String
        ): Call<SearchResultResponse>
    }
}


class GoogleSearcherFactory {
    companion object {
        @JvmStatic
        fun build(context: Context): IGoogleSearcher {
            return GoogleSearcher(
                NetworkManager(),
                createRequestBuilder(
                    context
                )
            )
        }

        private fun createRequestBuilder(
            context: Context,
            readTimeout: Long = 100
        ): RequestBuilder {
            val requestBuilder =
                RequestBuilder(
                    ClientProvider.getInstance().getHttpClient(
                        context,
                        readTimeout
                    )
                ).baseurl(BuildConfig.GOOGLE_SEARCH_URL)

            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                requestBuilder.httpClientBuilder
                    .addInterceptor(loggingInterceptor)

                requestBuilder.httpClientBuilder
                    .addNetworkInterceptor(CurlLoggingInterceptor())
            }

            return requestBuilder
        }
    }
}