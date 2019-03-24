package com.guyverhopkins.searchresults.core.networking.logging

import okhttp3.FormBody
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.URLEncoder

class OkHttpToCurlTest {

    @Test
    fun basicTest() {
        val request = Request.Builder().url("http://google.com").addHeader("cache-control", "no-cache").build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        val expected = "curl -X GET \\\n" +
                "http://google.com/ \\\n" +
                "-H 'cache-control: no-cache' \\\n"

        assertEquals(expected, curl)
    }

    @Test
    fun noHeaderTest() {
        val request = Request.Builder().url("http://google.com").build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        val expected = "curl -X GET \\\nhttp://google.com/ \\\n"

        assertEquals(expected, curl)
    }

    @Test
    fun bodyTest() {

        val elabel = "email"
        val tlabel = "tel"
        var email = "abc123@gmail.com"
        var phone = "(216)440-8585"

        val body = FormBody.Builder()
            .add(elabel, email)
            .add(tlabel, phone)
            .build()

        val request =
            Request.Builder().url("http://google.com").post(body).addHeader("cache-control", "no-cache").build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        email = URLEncoder.encode(email)
        phone = URLEncoder.encode(phone)

        val expected = "curl -X POST \\\n" +
                "http://google.com/ \\\n" +
                "-H 'cache-control: no-cache' \\\n" +
                "-d '" + elabel + "=" + email + "&" + tlabel + "=" + phone + "'"

        assertEquals(expected, curl)
    }

    @Test
    fun manyHeadersTest() {
        val request =
            Request.Builder().url("http://google.com").addHeader("cache-control", "no-cache").addHeader("a", "b")
                .addHeader("c", "d").addHeader("e", "f").addHeader("g", "h").build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        //headers are alphabetized
        val expected = "curl -X GET \\\n" +
                "http://google.com/ \\\n" +
                "-H 'a: b' \\\n" +
                "-H 'c: d' \\\n" +
                "-H 'cache-control: no-cache' \\\n" +
                "-H 'e: f' \\\n" +
                "-H 'g: h' \\\n"

        assertEquals(expected, curl)
    }

    @Test
    fun exampleFacebookAuthRequest() {
        val body = FormBody.Builder()
            .add("grant_type", "facebook_token")
            .add("client_id", "556b855a-c24a-446a-b492-18237e06989c")
            .add(
                "access_token",
                "EAAWtSjlE5SYBAPPiJUlPsjEpoZCWRfDPT3AiDtl6XEpwnhiE8TianmzJekM3v7WsHwc1FXTyQ3M2yYQAPgZB3O8ZBSj73uYS3ZAIxljZAXQzj6QdSS7wtYewsZCDtQgpCs8MQAZCnJjk1YaLKKHgPe7xpz1evtIZAA2pZBuwPhXpCifoQ7rMZAddv84yAMlGWIvqgsNpc4Utz9yRqysOYXfHCdhXLtmARZBxQiqzig5rdc4RZBE1hYptjVvw"
            )
            .add("fields", "id name email birthday")
            .add("scope", "offline_access")
            .build()

        val request = Request.Builder().url("https://devamtws.amtrustgroup.com/AuthServer_Dev/OpenIdConnect/Token")
            .addHeader("cache-control", "no-cache")
            .addHeader("content-type", "application/x-www-form-urlencoded")
            .addHeader("postman-token", "38452f9f-dc94-3b03-456d-29c8d6a7fa19").post(body).build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        val expected = "curl -X POST \\\n" +
                "https://devamtws.amtrustgroup.com/AuthServer_Dev/OpenIdConnect/Token \\\n" +
                "-H 'cache-control: no-cache' \\\n" +
                "-H 'content-type: application/x-www-form-urlencoded' \\\n" +
                "-H 'postman-token: 38452f9f-dc94-3b03-456d-29c8d6a7fa19' \\\n" +
                "-d 'grant_type=facebook_token&client_id=556b855a-c24a-446a-b492-18237e06989c&access_token=EAAWtSjlE5SYBAPPiJUlPsjEpoZCWRfDPT3AiDtl6XEpwnhiE8TianmzJekM3v7WsHwc1FXTyQ3M2yYQAPgZB3O8ZBSj73uYS3ZAIxljZAXQzj6QdSS7wtYewsZCDtQgpCs8MQAZCnJjk1YaLKKHgPe7xpz1evtIZAA2pZBuwPhXpCifoQ7rMZAddv84yAMlGWIvqgsNpc4Utz9yRqysOYXfHCdhXLtmARZBxQiqzig5rdc4RZBE1hYptjVvw&fields=id%20name%20email%20birthday&scope=offline_access'"

        assertEquals(expected, curl)
    }


    @Test
    fun deleteTest() {
        val request = Request.Builder().url("http://google.com").delete().build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        val expected = "curl -X DELETE \\\nhttp://google.com/ \\\n"

        assertEquals(expected, curl)
    }

    @Test
    fun getTest() {
        val request = Request.Builder().url("http://google.com").get().build()

        val curl = OkHttpToCurl.getCurlRequest(request)

        val expected = "curl -X GET \\\nhttp://google.com/ \\\n"

        assertEquals(expected, curl)
    }
}