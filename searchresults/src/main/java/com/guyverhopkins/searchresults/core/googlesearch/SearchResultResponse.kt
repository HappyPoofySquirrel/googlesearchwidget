package com.guyverhopkins.searchresults.core.googlesearch

import com.google.gson.annotations.SerializedName


/**
 * created by ghopkins 3/19/2019.
 */

data class SearchResultResponse(
    @SerializedName("context")
    val context: Context,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("queries")
    val queries: Queries,
    @SerializedName("searchInformation")
    val searchInformation: SearchInformation,
    @SerializedName("url")
    val url: Url
)

data class SearchInformation(
    @SerializedName("formattedSearchTime")
    val formattedSearchTime: String,
    @SerializedName("formattedTotalResults")
    val formattedTotalResults: String,
    @SerializedName("searchTime")
    val searchTime: Double,
    @SerializedName("totalResults")
    val totalResults: String
)

data class Url(
    @SerializedName("template")
    val template: String,
    @SerializedName("type")
    val type: String
)

data class Queries(
    @SerializedName("nextPage")
    val nextPage: List<NextPage>,
    @SerializedName("request")
    val request: List<Request>
)

data class Request(
    @SerializedName("count")
    val count: Int,
    @SerializedName("cx")
    val cx: String,
    @SerializedName("inputEncoding")
    val inputEncoding: String,
    @SerializedName("outputEncoding")
    val outputEncoding: String,
    @SerializedName("safe")
    val safe: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("totalResults")
    val totalResults: String
)

data class NextPage(
    @SerializedName("count")
    val count: Int,
    @SerializedName("cx")
    val cx: String,
    @SerializedName("inputEncoding")
    val inputEncoding: String,
    @SerializedName("outputEncoding")
    val outputEncoding: String,
    @SerializedName("safe")
    val safe: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("totalResults")
    val totalResults: String
)

data class Item(
    @SerializedName("cacheId")
    val cacheId: String,
    @SerializedName("displayLink")
    val displayLink: String,
    @SerializedName("formattedUrl")
    val formattedUrl: String,
    @SerializedName("htmlFormattedUrl")
    val htmlFormattedUrl: String,
    @SerializedName("htmlSnippet")
    val htmlSnippet: String,
    @SerializedName("htmlTitle")
    val htmlTitle: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pagemap")
    val pagemap: Pagemap,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("title")
    val title: String
)

data class Pagemap(
    @SerializedName("cse_image")
    val cseImage: List<CseImage>,
    @SerializedName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnail>,
    @SerializedName("metatags")
    val metatags: List<Metatag>
)

data class CseImage(
    @SerializedName("src")
    val src: String
)

data class Metatag(
    @SerializedName("msapplication-tileimage")
    val msapplicationTileimage: String,
    @SerializedName("og:description")
    val ogDescription: String,
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:image:height")
    val ogImageHeight: String,
    @SerializedName("og:image:secure_url")
    val ogImageSecureUrl: String,
    @SerializedName("og:image:width")
    val ogImageWidth: String,
    @SerializedName("og:locale")
    val ogLocale: String,
    @SerializedName("og:site_name")
    val ogSiteName: String,
    @SerializedName("og:title")
    val ogTitle: String,
    @SerializedName("og:type")
    val ogType: String,
    @SerializedName("og:url")
    val ogUrl: String,
    @SerializedName("p:domain_verify")
    val pDomainVerify: String,
    @SerializedName("twitter:card")
    val twitterCard: String,
    @SerializedName("twitter:creator")
    val twitterCreator: String,
    @SerializedName("twitter:description")
    val twitterDescription: String,
    @SerializedName("twitter:image")
    val twitterImage: String,
    @SerializedName("twitter:site")
    val twitterSite: String,
    @SerializedName("twitter:title")
    val twitterTitle: String,
    @SerializedName("viewport")
    val viewport: String
)

data class CseThumbnail(
    @SerializedName("height")
    val height: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("width")
    val width: String
)

data class Context(
    @SerializedName("title")
    val title: String
)