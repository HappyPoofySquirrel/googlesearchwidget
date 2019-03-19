package com.guyverhopkins.searchresults.core.networking.logging

import okhttp3.Request
import okio.Buffer
import java.io.IOException

object OkHttpToCurl {

    fun getCurlRequest(request: Request): String {

        val curlRequest = StringBuilder()
        curlRequest.append("curl -X " + request.method() + " \\\n")
        curlRequest.append(request.url()).append(" \\\n")

        for (header in request.headers().names()) {
            curlRequest.append("-H '").append(header).append(": ").append(request.headers().get(header))
                .append("' \\\n")
        }

        //if request.body is null, contentLength() will return -1. Statement is true if contentLength() is greater than 0.
        if (request.body()?.contentLength() ?: -1 > 0) {
            try {
                val buffer = Buffer()
                request.body()?.writeTo(buffer)
                val body = buffer.readUtf8()
                curlRequest.append("-d '").append(body).append("'")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return curlRequest.toString()
    }
}