package com.guyverhopkins.searchresults.core.networking

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Created by jlorett on 9/13/16.
 */
class NetworkManager : INetworkManager {

    override fun <T> enqueueCall(
        call: Call<T>,
        listener: INetworkManager.NetworkCallback,
        cancelledCallback: INetworkManager.CancelledCallback?
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    listener.onResponse(response)
                } else {
                    listener.onFailure(NetworkError(response, NetworkError.NetworkReason.NETWORK))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkError = if (t == null)
                    NetworkError()
                else
                    NetworkError(t.toString())

                if (call.isCanceled) {
                    networkError.reason = NetworkError.NetworkReason.CANCELLED
                    cancelledCallback?.onCancelled()
                } else {
                    networkError.reason = NetworkError.NetworkReason.JSON_PARSING
                    listener.onFailure(networkError)
                }
            }
        })
    }

    @Throws(IOException::class)
    override fun <T> executeCall(call: Call<T>): Response<*> {
        return call.execute()
    }
}
