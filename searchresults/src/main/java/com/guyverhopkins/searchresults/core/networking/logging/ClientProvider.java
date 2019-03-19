package com.guyverhopkins.searchresults.core.networking.logging;

import android.content.Context;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Provide httpclient singleton.
 */
public class ClientProvider {
    private static final int CACHE_SIZE = 1024;
    private static ClientProvider ourInstance = new ClientProvider();
    private static OkHttpClient httpClient;
    private static int DEFAULT_READ_TIMEOUT = 10;

    private static TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

    private ClientProvider() {
    }

    public static ClientProvider getInstance() {
        return ourInstance;
    }

    public OkHttpClient getHttpClient(Context context) {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .cache(new Cache(context.getCacheDir(), CACHE_SIZE))
                    .readTimeout(DEFAULT_READ_TIMEOUT, DEFAULT_TIME_UNIT)
                    .build();
        }

        return httpClient;
    }

    public OkHttpClient getHttpClient(Context context, long readTimeout) {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .cache(new Cache(context.getCacheDir(), CACHE_SIZE))
                    .readTimeout(readTimeout, DEFAULT_TIME_UNIT)
                    .build();
        } else {
            httpClient = httpClient.newBuilder()
                    .cache(new Cache(context.getCacheDir(), CACHE_SIZE))
                    .readTimeout(readTimeout, DEFAULT_TIME_UNIT)
                    .build();
        }

        return httpClient;
    }
}
