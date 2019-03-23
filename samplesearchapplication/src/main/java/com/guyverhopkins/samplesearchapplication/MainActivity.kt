package com.guyverhopkins.samplesearchapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.guyverhopkins.searchresults.ui.SearchResultErrorMessageListener
import com.guyverhopkins.searchresults.ui.SearchResultLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchResultErrorMessageListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //optional if you want to show errors
        val sr_searchResults = srl_resuls as SearchResultLayout
        sr_searchResults.attachListener(this)
    }

    override fun onError(message: String) {
        Snackbar.make(main_container, message, Snackbar.LENGTH_LONG).show()
    }
}
