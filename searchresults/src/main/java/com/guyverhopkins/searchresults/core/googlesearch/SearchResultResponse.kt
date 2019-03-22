package com.guyverhopkins.searchresults.core.googlesearch

import com.google.gson.annotations.SerializedName


/**
 * created by ghopkins 3/19/2019.
 */

data class SearchResultResponse(
    @SerializedName("context")
    val context: Context,
    @SerializedName("items")
    val items: MutableList<SearchResultItem>,
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


val mockResponse = "{\n" +
        " \"kind\": \"customsearch#search\",\n" +
        " \"url\": {\n" +
        "  \"type\": \"application/json\",\n" +
        "  \"template\": \"https://www.googleapis.com/customsearch/v1?q={searchTerms}&num={count?}&start={startIndex?}&lr={language?}&safe={safe?}&cx={cx?}&sort={sort?}&filter={filter?}&gl={gl?}&cr={cr?}&googlehost={googleHost?}&c2coff={disableCnTwTranslation?}&hq={hq?}&hl={hl?}&siteSearch={siteSearch?}&siteSearchFilter={siteSearchFilter?}&exactTerms={exactTerms?}&excludeTerms={excludeTerms?}&linkSite={linkSite?}&orTerms={orTerms?}&relatedSite={relatedSite?}&dateRestrict={dateRestrict?}&lowRange={lowRange?}&highRange={highRange?}&searchType={searchType}&fileType={fileType?}&rights={rights?}&imgSize={imgSize?}&imgType={imgType?}&imgColorType={imgColorType?}&imgDominantColor={imgDominantColor?}&alt=json\"\n" +
        " },\n" +
        " \"queries\": {\n" +
        "  \"request\": [\n" +
        "   {\n" +
        "    \"title\": \"Google Custom Search - Thunderhead ONE\",\n" +
        "    \"totalResults\": \"14000\",\n" +
        "    \"searchTerms\": \"Thunderhead ONE\",\n" +
        "    \"count\": 10,\n" +
        "    \"startIndex\": 1,\n" +
        "    \"inputEncoding\": \"utf8\",\n" +
        "    \"outputEncoding\": \"utf8\",\n" +
        "    \"safe\": \"off\",\n" +
        "    \"cx\": \"004419588007990612847:clcqmqeskvw\"\n" +
        "   }\n" +
        "  ],\n" +
        "  \"nextPage\": [\n" +
        "   {\n" +
        "    \"title\": \"Google Custom Search - Thunderhead ONE\",\n" +
        "    \"totalResults\": \"14000\",\n" +
        "    \"searchTerms\": \"Thunderhead ONE\",\n" +
        "    \"count\": 10,\n" +
        "    \"startIndex\": 11,\n" +
        "    \"inputEncoding\": \"utf8\",\n" +
        "    \"outputEncoding\": \"utf8\",\n" +
        "    \"safe\": \"off\",\n" +
        "    \"cx\": \"004419588007990612847:clcqmqeskvw\"\n" +
        "   }\n" +
        "  ]\n" +
        " },\n" +
        " \"context\": {\n" +
        "  \"title\": \"Google\"\n" +
        " },\n" +
        " \"searchInformation\": {\n" +
        "  \"searchTime\": 0.227483,\n" +
        "  \"formattedSearchTime\": \"0.23\",\n" +
        "  \"totalResults\": \"14000\",\n" +
        "  \"formattedTotalResults\": \"14,000\"\n" +
        " },\n" +
        " \"items\": [\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"Customer Engagement Platform | ONE Engagement Hub ...\",\n" +
        "   \"htmlTitle\": \"Customer Engagement Platform | <b>ONE</b> Engagement Hub ...\",\n" +
        "   \"link\": \"https://www.thunderhead.com/one-engagement-hub/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Discover Thunderhead's ONE Engagement Hub. The only cloud customer \\nengagement platform which can deliver truly intent-driven customer journeys.\",\n" +
        "   \"htmlSnippet\": \"Discover <b>Thunderhead&#39;s ONE</b> Engagement Hub. The only cloud customer <br>\\nengagement platform which can deliver truly intent-driven customer journeys.\",\n" +
        "   \"cacheId\": \"WFi5JIMHOG0J\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/one-engagement-hub/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/<b>one</b>-engagement-hub/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"295\",\n" +
        "      \"height\": \"171\",\n" +
        "      \"src\": \"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS9rELbn4gNDvVPcL36ERrzbIqkZ113FY7-ueWF0xHkai0PPeSkPWNvT4c\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"Customer Engagement Platform | ONE Engagement Hub | Thunderhead\",\n" +
        "      \"og:description\": \"Discover Thunderhead's ONE Engagement Hub. The only cloud customer engagement platform which can deliver truly intent-driven customer journeys.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/one-engagement-hub/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/ONE-product-page-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/ONE-product-page-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:width\": \"746\",\n" +
        "      \"og:image:height\": \"432\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Discover Thunderhead's ONE Engagement Hub. The only cloud customer engagement platform which can deliver truly intent-driven customer journeys.\",\n" +
        "      \"twitter:title\": \"Customer Engagement Platform | ONE Engagement Hub | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/ONE-product-page-featured-image.png?fit=746,432\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/ONE-product-page-featured-image.png?fit=746,432\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"Thunderhead - Understand Intent-Driven Customer Journeys\",\n" +
        "   \"htmlTitle\": \"<b>Thunderhead</b> - Understand Intent-Driven Customer Journeys\",\n" +
        "   \"link\": \"https://www.thunderhead.com/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"THUNDERHEAD NAMED A LEADER IN CUSTOMER JOURNEY ANALYTICS \\nMARKET. Thunderhead's ONE Engagement Hub platform scores among highest\\n ...\",\n" +
        "   \"htmlSnippet\": \"THUNDERHEAD NAMED A LEADER IN CUSTOMER JOURNEY ANALYTICS <br>\\nMARKET. <b>Thunderhead&#39;s ONE</b> Engagement Hub platform scores among highest<br>\\n&nbsp;...\",\n" +
        "   \"cacheId\": \"XQRU7c2gWsQJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"295\",\n" +
        "      \"height\": \"171\",\n" +
        "      \"src\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxlITRiHgpEYq7Nkb4z5Ajx7pRTv78jedkyFZAWN47DSrzXPYbKGN5iVg\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"website\",\n" +
        "      \"og:title\": \"Thunderhead - Understand Intent-Driven Customer Journeys\",\n" +
        "      \"og:description\": \"Thunderhead helps brands to understand intent-driven customer journeys for true customer engagement and more valuable customer relationships.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/HOME-page-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/HOME-page-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:width\": \"746\",\n" +
        "      \"og:image:height\": \"432\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Thunderhead helps brands to understand intent-driven customer journeys for true customer engagement and more valuable customer relationships.\",\n" +
        "      \"twitter:title\": \"Thunderhead - Understand Intent-Driven Customer Journeys\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/HOME-page-featured-image.png?fit=746,432\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/HOME-page-featured-image.png?fit=746,432\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"Thunderhead ONE Engagement Hub Overview - Thunderhead\",\n" +
        "   \"htmlTitle\": \"<b>Thunderhead ONE</b> Engagement Hub Overview - Thunderhead\",\n" +
        "   \"link\": \"https://www.thunderhead.com/useful-stuff/thunderhead-one-engagement-hub-overview/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"This quick overview of Thunderhead's ONE Engagement Hub takes you through \\nONE's features, how it works, the value brands get from it, and what some of our ...\",\n" +
        "   \"htmlSnippet\": \"This quick overview of <b>Thunderhead&#39;s ONE</b> Engagement Hub takes you through <br>\\nONE&#39;s features, how it works, the value brands get from it, and what some of our&nbsp;...\",\n" +
        "   \"cacheId\": \"_iiLmXYYWYwJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/.../thunderhead-one-engagement-hub- overview/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/.../<b>thunderhead</b>-<b>one</b>-engagement-hub- overview/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"189\",\n" +
        "      \"height\": \"267\",\n" +
        "      \"src\": \"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTPisnK7-btcDSbG435Xtzg5ECsRtGe4m1fQdFu_HJDRiNgH9nuFPqidLB-\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"Thunderhead ONE Engagement Hub Overview - Thunderhead\",\n" +
        "      \"og:description\": \"What is the ONE Engagement Hub? This quick overview of Thunderhead’s ONE Engagement Hub takes you through ONE’s features, how it works, the value brands get from it, and what some of our customers have to say. In a nutshell, ONE is an intelligent, AI-powered, engagement hub that helps you understand each customer’s true intent …\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/useful-stuff/thunderhead-one-engagement-hub-overview/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2018/09/Thunderhead-ONE-Engagement-Hub-Overview_Page_1-1.png?fit=1249,1766\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2018/09/Thunderhead-ONE-Engagement-Hub-Overview_Page_1-1.png?fit=1249,1766\",\n" +
        "      \"og:image:width\": \"1249\",\n" +
        "      \"og:image:height\": \"1766\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"What is the ONE Engagement Hub? This quick overview of Thunderhead’s ONE Engagement Hub takes you through ONE’s features, how it works, the value brands get from it, and what some of our customers have to say. In a nutshell, ONE is an intelligent, AI-powered, engagement hub that helps you understand each customer’s true intent […]\",\n" +
        "      \"twitter:title\": \"Thunderhead ONE Engagement Hub Overview - Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2018/09/Thunderhead-ONE-Engagement-Hub-Overview_Page_1-1.png?fit=1249,1766\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2018/09/Thunderhead-ONE-Engagement-Hub-Overview_Page_1-1.png?fit=1249,1766\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"The Value of ONE | To Build Customer Engagement | Thunderhead\",\n" +
        "   \"htmlTitle\": \"The Value of <b>ONE</b> | To Build Customer Engagement | <b>Thunderhead</b>\",\n" +
        "   \"link\": \"https://www.thunderhead.com/one-engagement-hub/value-of-one/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Do you want to achieve happier customers through effortless engagement? Then \\nthe ONE Engagement Hub is for you. Discover the value of ONE for your ...\",\n" +
        "   \"htmlSnippet\": \"Do you want to achieve happier customers through effortless engagement? Then <br>\\nthe <b>ONE</b> Engagement Hub is for you. Discover the value of <b>ONE</b> for your&nbsp;...\",\n" +
        "   \"cacheId\": \"2yTw4T5dfr8J\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/one-engagement-hub/value-of-one/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/<b>one</b>-engagement-hub/value-of-<b>one</b>/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"The Value of ONE | To Build Customer Engagement | Thunderhead\",\n" +
        "      \"og:description\": \"Do you want to achieve happier customers through effortless engagement? Then the ONE Engagement Hub is for you. Discover the value of ONE for your business.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/one-engagement-hub/value-of-one/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Do you want to achieve happier customers through effortless engagement? Then the ONE Engagement Hub is for you. Discover the value of ONE for your business.\",\n" +
        "      \"twitter:title\": \"The Value of ONE | To Build Customer Engagement | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"ONE Engagement Hub Geek Sheet | Product Information ...\",\n" +
        "   \"htmlTitle\": \"<b>ONE</b> Engagement Hub Geek Sheet | Product Information ...\",\n" +
        "   \"link\": \"https://www.thunderhead.com/useful-stuff/one-engagement-hub-geek-sheet/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Get down and dirty with the nuts and bolts that make up Thunderhead's ONE \\nEngagement Hub. This Geek Sheet (you know who you are) gives you a look \\nunder ...\",\n" +
        "   \"htmlSnippet\": \"Get down and dirty with the nuts and bolts that make up <b>Thunderhead&#39;s ONE</b> <br>\\nEngagement Hub. This Geek Sheet (you know who you are) gives you a look <br>\\nunder&nbsp;...\",\n" +
        "   \"cacheId\": \"j1_3rwl-9_sJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/.../one-engagement-hub-geek-sheet/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/.../<b>one</b>-engagement-hub-geek-sheet/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"295\",\n" +
        "      \"height\": \"171\",\n" +
        "      \"src\": \"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRxf-Qx2PmU-XngkCIHQ9I_zKz62RwcgIolNV1WE32eVabiqidTwsK3GQk\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"ONE Engagement Hub Geek Sheet | Product Information | Thunderhead\",\n" +
        "      \"og:description\": \"Get down and dirty with the nuts and bolts that make up Thunderhead's ONE Engagement Hub customer engagement platform. Learn how the key parts of ONE work.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/useful-stuff/one-engagement-hub-geek-sheet/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/Geek-Sheet.png?fit=746,432\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/Geek-Sheet.png?fit=746,432\",\n" +
        "      \"og:image:width\": \"746\",\n" +
        "      \"og:image:height\": \"432\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Get down and dirty with the nuts and bolts that make up Thunderhead's ONE Engagement Hub customer engagement platform. Learn how the key parts of ONE work.\",\n" +
        "      \"twitter:title\": \"ONE Engagement Hub Geek Sheet | Product Information | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/Geek-Sheet.png?fit=746,432\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/06/Geek-Sheet.png?fit=746,432\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"About Us | Meet The Team Creating Engaged Customers ...\",\n" +
        "   \"htmlTitle\": \"About Us | Meet The Team Creating Engaged Customers ...\",\n" +
        "   \"link\": \"https://www.thunderhead.com/about/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Discover how Thunderhead, a recognised customer engagement market leader, \\nand the ONE Engagement Hub bring effortless customer engagement to your ...\",\n" +
        "   \"htmlSnippet\": \"Discover how <b>Thunderhead</b>, a recognised customer engagement market leader, <br>\\nand the <b>ONE</b> Engagement Hub bring effortless customer engagement to your&nbsp;...\",\n" +
        "   \"cacheId\": \"OsLAAnje8JYJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/about/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/about/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"323\",\n" +
        "      \"height\": \"156\",\n" +
        "      \"src\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqhnN6aoTWBrumWj3v3ifO_CberluZ5PXYmaNfivKg-9VNN9KeMhriq3nR\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"About Us | Meet The Team Creating Engaged Customers | Thunderhead\",\n" +
        "      \"og:description\": \"Discover how Thunderhead, a recognised customer engagement market leader, and the ONE Engagement Hub bring effortless customer engagement to your business.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/about/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/Thunderhead_LogoIcon_Aubergine.png?fit=512,247\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/Thunderhead_LogoIcon_Aubergine.png?fit=512,247\",\n" +
        "      \"og:image:width\": \"512\",\n" +
        "      \"og:image:height\": \"247\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Discover how Thunderhead, a recognised customer engagement market leader, and the ONE Engagement Hub bring effortless customer engagement to your business.\",\n" +
        "      \"twitter:title\": \"About Us | Meet The Team Creating Engaged Customers | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/Thunderhead_LogoIcon_Aubergine.png?fit=512,247\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2015/07/Thunderhead_LogoIcon_Aubergine.png?fit=512,247\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"ONE Engagement Hub and Microsoft Dynamics CRM | Solution Brief\",\n" +
        "   \"htmlTitle\": \"<b>ONE</b> Engagement Hub and Microsoft Dynamics CRM | Solution Brief\",\n" +
        "   \"link\": \"https://www.thunderhead.com/useful-stuff/one-engagement-hub-and-microsoft-dynamics-crm/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Read this solution brief to understand how Thunderhead's ONE Engagement \\nHub integrates with Microsoft Dynamics CRM for omni-channel Customer ...\",\n" +
        "   \"htmlSnippet\": \"Read this solution brief to understand how <b>Thunderhead&#39;s ONE</b> Engagement <br>\\nHub integrates with Microsoft Dynamics CRM for omni-channel Customer&nbsp;...\",\n" +
        "   \"cacheId\": \"2SGeaEAyY7AJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/.../one-engagement-hub-and-microsoft- dynamics-crm/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/.../<b>one</b>-engagement-hub-and-microsoft- dynamics-crm/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"ONE Engagement Hub and Microsoft Dynamics CRM | Solution Brief\",\n" +
        "      \"og:description\": \"Read this solution brief to understand how Thunderhead's ONE Engagement Hub integrates with Microsoft Dynamics CRM for omni-channel Customer Engagement.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/useful-stuff/one-engagement-hub-and-microsoft-dynamics-crm/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://hmn-uploads-eu.s3.amazonaws.com/thunderhead-production-v2/uploads/2015/07/MS-DYNAMICS-NEW-VI-v3_Page_1-212x300.png\",\n" +
        "      \"og:image:secure_url\": \"https://hmn-uploads-eu.s3.amazonaws.com/thunderhead-production-v2/uploads/2015/07/MS-DYNAMICS-NEW-VI-v3_Page_1-212x300.png\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Read this solution brief to understand how Thunderhead's ONE Engagement Hub integrates with Microsoft Dynamics CRM for omni-channel Customer Engagement.\",\n" +
        "      \"twitter:title\": \"ONE Engagement Hub and Microsoft Dynamics CRM | Solution Brief\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://hmn-uploads-eu.s3.amazonaws.com/thunderhead-production-v2/uploads/2015/07/MS-DYNAMICS-NEW-VI-v3_Page_1-212x300.png\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://hmn-uploads-eu.s3.amazonaws.com/thunderhead-production-v2/uploads/2015/07/MS-DYNAMICS-NEW-VI-v3_Page_1-212x300.png\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"Thunderhead Resources\",\n" +
        "   \"htmlTitle\": \"<b>Thunderhead</b> Resources\",\n" +
        "   \"link\": \"https://www.thunderhead.com/useful-stuff/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Ovum SWOT Assessment ONE Engagement Hub · Product Info: HOW ONE \\nHELPS SPORTS TEAMS · Infographic: Infographic Stop Thinking Channels Start\\n ...\",\n" +
        "   \"htmlSnippet\": \"Ovum SWOT Assessment <b>ONE</b> Engagement Hub &middot; Product Info: HOW <b>ONE</b> <br>\\nHELPS SPORTS TEAMS &middot; Infographic: Infographic Stop Thinking Channels Start<br>\\n&nbsp;...\",\n" +
        "   \"cacheId\": \"KwPaa7XHWIoJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/useful-stuff/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/useful-stuff/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"297\",\n" +
        "      \"height\": \"170\",\n" +
        "      \"src\": \"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQwLtlrlVM9BRv9C6J-ih0ImAaPBG3KLYaf7ccVdaTvK2iT2EPrrdxutJI\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"object\",\n" +
        "      \"og:title\": \"Thunderhead Resources\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/useful-stuff/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Discover Thunderhead's range of resources including case studies, whitepapers and solution briefs to help inform your customer engagement strategy.\",\n" +
        "      \"twitter:title\": \"Thunderhead Resources\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2018/11/Featured-Image.jpg?resize=580,332\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"Help and Support | ONE Engagement Hub Training | Thunderhead\",\n" +
        "   \"htmlTitle\": \"Help and Support | <b>ONE</b> Engagement Hub Training | <b>Thunderhead</b>\",\n" +
        "   \"link\": \"https://www.thunderhead.com/support/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Our self-service support portal makes it easy to ask for help, track progress on \\ntickets, search knowledge base and feedback on the ONE Engagement Hub.\",\n" +
        "   \"htmlSnippet\": \"Our self-service support portal makes it easy to ask for help, track progress on <br>\\ntickets, search knowledge base and feedback on the <b>ONE</b> Engagement Hub.\",\n" +
        "   \"cacheId\": \"aryeNk7LdQsJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/support/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/support/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"Help and Support | ONE Engagement Hub Training | Thunderhead\",\n" +
        "      \"og:description\": \"Our self-service support portal makes it easy to ask for help, track progress on tickets, search knowledge base and feedback on the ONE Engagement Hub.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/support/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Our self-service support portal makes it easy to ask for help, track progress on tickets, search knowledge base and feedback on the ONE Engagement Hub.\",\n" +
        "      \"twitter:title\": \"Help and Support | ONE Engagement Hub Training | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  },\n" +
        "  {\n" +
        "   \"kind\": \"customsearch#result\",\n" +
        "   \"title\": \"ONE Engagement Hub in Action | 3 Minute Video | Thunderhead\",\n" +
        "   \"htmlTitle\": \"<b>ONE</b> Engagement Hub in Action | 3 Minute Video | <b>Thunderhead</b>\",\n" +
        "   \"link\": \"https://www.thunderhead.com/useful-stuff/one-in-action/\",\n" +
        "   \"displayLink\": \"www.thunderhead.com\",\n" +
        "   \"snippet\": \"Thunderhead's ONE Engagement Hub is the only truly light-touch, conversation-\\ndriven customer engagement platform. Watch our 3 minute video to learn more.\",\n" +
        "   \"htmlSnippet\": \"<b>Thunderhead&#39;s ONE</b> Engagement Hub is the only truly light-touch, conversation-<br>\\ndriven customer engagement platform. Watch our 3 minute video to learn more.\",\n" +
        "   \"cacheId\": \"oBlAlBIyUZsJ\",\n" +
        "   \"formattedUrl\": \"https://www.thunderhead.com/useful-stuff/one-in-action/\",\n" +
        "   \"htmlFormattedUrl\": \"https://www.<b>thunderhead</b>.com/useful-stuff/<b>one</b>-in-action/\",\n" +
        "   \"pagemap\": {\n" +
        "    \"cse_thumbnail\": [\n" +
        "     {\n" +
        "      \"width\": \"295\",\n" +
        "      \"height\": \"171\",\n" +
        "      \"src\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtz--2KeKDM1rhN7KEnrq4PbIVxrvrbKb9RiSwcwWB4mDQW9qX3krS81E\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"metatags\": [\n" +
        "     {\n" +
        "      \"viewport\": \"width=device-width, initial-scale=1\",\n" +
        "      \"og:locale\": \"en_GB\",\n" +
        "      \"og:type\": \"article\",\n" +
        "      \"og:title\": \"ONE Engagement Hub in Action | 3 Minute Video | Thunderhead\",\n" +
        "      \"og:description\": \"Thunderhead's ONE Engagement Hub is the only truly light-touch, conversation-driven customer engagement platform. Watch our 3 minute video to learn more.\",\n" +
        "      \"og:url\": \"https://www.thunderhead.com/useful-stuff/one-in-action/\",\n" +
        "      \"og:site_name\": \"Thunderhead\",\n" +
        "      \"og:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/09/oia-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:secure_url\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/09/oia-featured-image.png?fit=746,432\",\n" +
        "      \"og:image:width\": \"746\",\n" +
        "      \"og:image:height\": \"432\",\n" +
        "      \"twitter:card\": \"summary_large_image\",\n" +
        "      \"twitter:description\": \"Thunderhead's ONE Engagement Hub is the only truly light-touch, conversation-driven customer engagement platform. Watch our 3 minute video to learn more.\",\n" +
        "      \"twitter:title\": \"ONE Engagement Hub in Action | 3 Minute Video | Thunderhead\",\n" +
        "      \"twitter:site\": \"@ThunderheadONE\",\n" +
        "      \"twitter:image\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/09/oia-featured-image.png?fit=746,432\",\n" +
        "      \"twitter:creator\": \"@ThunderheadONE\",\n" +
        "      \"p:domain_verify\": \"bfb583e733a41e0535d3046b47185811\",\n" +
        "      \"msapplication-tileimage\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/01/cropped-Thunderhead_favicon.png?fit=270,270\"\n" +
        "     }\n" +
        "    ],\n" +
        "    \"cse_image\": [\n" +
        "     {\n" +
        "      \"src\": \"https://eu-west-1.tchyn.io/thunderhead-production-v2/uploads/2016/09/oia-featured-image.png?fit=746,432\"\n" +
        "     }\n" +
        "    ]\n" +
        "   }\n" +
        "  }\n" +
        " ]\n" +
        "}"