package com.guyverhopkins.searchresults.core.googlesearch

import android.content.Context
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import java.io.File

/**
 * created by ghopkins 3/24/2019.
 */
class GoogleSearcherTest {
    @Test
    fun factoryDoesNotReturnNUll() {
        val context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.cacheDir).thenReturn(File(""))
        assertNotNull(GoogleSearcherFactory.build(context))
    }
}