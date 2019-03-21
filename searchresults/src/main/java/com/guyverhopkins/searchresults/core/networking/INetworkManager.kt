package com.guyverhopkins.searchresults.core.networking

import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 * Makes a network request.
 * Created by jlorett on 9/13/16.
 */
interface INetworkManager {
    interface NetworkCallback {
        fun onResponse(response: Response<*>)

        fun onFailure(networkError: NetworkError)
    }

    interface CancelledCallback {
        fun onCancelled()
    }

    fun <T> enqueueCall(call: Call<T>, listener: NetworkCallback, cancelledCallback: CancelledCallback? = null)

    @Throws(IOException::class)
    fun <T> executeCall(call: Call<T>): Response<*>
}
