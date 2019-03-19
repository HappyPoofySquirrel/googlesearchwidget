package com.guyverhopkins.searchresults.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.guyverhopkins.searchresults.R

/**
 * created by ghopkins 3/19/2019.
 */
class SearchResults : LinearLayout {

    private var maxResultCount = 0

    private lateinit var rvSearchResults: RecyclerView

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.search_results, this)
        rvSearchResults = view.findViewById(R.id.rv_search_results)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchResults)
        maxResultCount = typedArray.getInt(R.styleable.SearchResults_max_search_results, 5)
        typedArray.recycle()
    }
}