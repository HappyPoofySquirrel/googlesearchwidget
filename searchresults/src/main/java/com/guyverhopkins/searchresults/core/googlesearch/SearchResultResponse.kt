package com.guyverhopkins.searchresults.core.googlesearch

import com.google.gson.annotations.SerializedName


/**
 * created by ghopkins 3/19/2019.
 */
data class SearchResultResponse(
    @SerializedName("context")
    val context: Context,
    @SerializedName("items")
    val items: List<SearchResultItem>,
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

data class SearchResultItem(
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
    val cseThumbnail: List<CseThumbnail>?,
    @SerializedName("metatags")
    val metatags: List<Metatag>,
    @SerializedName("videoobject")
    val videoobject: List<Videoobject>?
)

data class CseImage(
    @SerializedName("src")
    val src: String
)

data class Metatag(
    @SerializedName("article:modified_time")
    val articleModifiedTime: String,
    @SerializedName("article:published_time")
    val articlePublishedTime: String,
    @SerializedName("article:publisher")
    val articlePublisher: String,
    @SerializedName("article:section")
    val articleSection: String,
    @SerializedName("article:tag")
    val articleTag: String,
    @SerializedName("og:description")
    val ogDescription: String,
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:image:height")
    val ogImageHeight: String,
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
    @SerializedName("og:video:tag")
    val ogVideoTag: String?,
    @SerializedName("og:updated_time")
    val ogUpdatedTime: String,
    @SerializedName("og:url")
    val ogUrl: String,
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

data class Videoobject(
    @SerializedName("channelid")
    val channelid: String,
    @SerializedName("datepublished")
    val datepublished: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("embedurl")
    val embedurl: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("interactioncount")
    val interactioncount: String,
    @SerializedName("isfamilyfriendly")
    val isfamilyfriendly: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("paid")
    val paid: String,
    @SerializedName("playertype")
    val playertype: String,
    @SerializedName("regionsallowed")
    val regionsallowed: String,
    @SerializedName("thumbnailurl")
    val thumbnailurl: String,
    @SerializedName("unlisted")
    val unlisted: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("videoid")
    val videoid: String,
    @SerializedName("width")
    val width: String
)

data class CseThumbnail(
    @SerializedName("height")
    val height: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("width")
    val width: String
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

data class Context(
    @SerializedName("title")
    val title: String
)