# Google Search Results on Android for Thunderhead ONE

----------
This easy to use library will help you display google search results in your project.

# How to use

**to include SearchBar to your project:**

 add this code to the the app level build.gradle file

```gradle
dependencies {

}
```

add thunderhead_search_results.aar to your modules lib filder

then add SearchResults to your activity:

```xml
 <com.guyverhopkins.searchresults.ui.SearchResultLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/srl_resuls"
            app:max_search_results="14"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"/>
```

If you would like to listen for error messages you must attach the listener

```
onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)


        val sr_searchResults = srl_resuls as SearchResultLayout
        sr_searchResults.attachListener(this)
    }
```

