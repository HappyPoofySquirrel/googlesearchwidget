package com.guyverhopkins.searchresults.core

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * created by ghopkins 3/23/2019.
 */
fun String.fromHtml(): Spanned { //thanks stack overflow
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}