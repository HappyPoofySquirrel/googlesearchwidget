package com.guyverhopkins.searchresults.core.networking.logging;


import android.util.Log;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * Log requests using the cURL format.
 * <p>
 * Created 10/8/18
 */


public class CurlLoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i("Curl:", OkHttpToCurl.INSTANCE.getCurlRequest(chain.request()));
        return chain.proceed(chain.request());
    }
}
