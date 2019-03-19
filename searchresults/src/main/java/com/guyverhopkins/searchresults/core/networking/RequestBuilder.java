package com.guyverhopkins.searchresults.core.networking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestBuilder {
    private String baseUrl;

    private OkHttpClient httpClient;

    private OkHttpClient.Builder httpClientBuilder;

    public RequestBuilder(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        httpClientBuilder = httpClient.newBuilder();
    }

    public OkHttpClient.Builder getHttpClientBuilder() {
        return httpClientBuilder;
    }

    public void set(OkHttpClient.Builder builder) {
        httpClientBuilder = builder;
    }

    public RequestBuilder baseurl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /***
     * Build a request with the specified parameters from this class.
     * @param requestClass The request class needed for Retrofit.
     * @param <T> The request class we want to build.
     * @return Request class ready to be called.
     */
    public <T> T build(Class<T> requestClass) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        if (baseUrl != null) {
            retrofitBuilder.baseUrl(baseUrl);
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.client(httpClientBuilder.build());

        return retrofitBuilder.build().create(requestClass);
    }
}
