package com.guyverhopkins.searchresults.core.networking

import retrofit2.Response

/**
 * An error response from the network.
 *
 * Created by jlorett on 9/13/16.
 */
class NetworkError {
    var response: Response<*>? = null

    var message: String? = null

    var reason: NetworkReason? = null

    val statusCode: Int
        get() = if (response == null) -1 else response!!.code()

    enum class NetworkReason {
        NETWORK,
        JSON_PARSING,
        CANCELLED,
        UNKNOWN
    }

    constructor()

    constructor(reason: NetworkReason) {
        this.reason = reason
    }

    constructor(response: Response<*>, reason: NetworkReason) {
        this.response = response
        this.message = response.message()
        this.reason = reason
    }

    constructor(response: Response<*>) {
        this.response = response
        this.message = response.message()
        this.reason = NetworkReason.UNKNOWN
    }

    constructor(message: String) {
        this.message = message
    }
}
