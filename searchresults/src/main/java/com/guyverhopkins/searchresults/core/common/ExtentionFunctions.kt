package com.guyverhopkins.searchresults.core.common

import android.os.Build
import android.text.Html
import android.text.Spanned
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

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

fun String.formatDatePosted(): String {
    val dateInput: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val date = dateInput.parse(this)
    val dateOutput = SimpleDateFormat("MMM d, yyyy")
    return dateOutput.format(date)
}