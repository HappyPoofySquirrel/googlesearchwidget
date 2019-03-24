# Google Search Results on Android for Thunderhead ONE

This easy to use library will help you display google search results for Thunderhead ONE in your project.

# How to use

**to include SearchBar to your project:**

 add this code to the the app level build.gradle file

```gradle
dependencies {

}
```

add thunderhead_search_results.aar to the desired modules lib folder

then add SearchResults to your activity:

```xml
 <com.guyverhopkins.searchresults.ui.SearchResultLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:max_search_results="14"  />
```
  You must specify how many results you would like to receive using the following property
  ```xml
  app:max_search_results="14"
```


If you would like to listen for errors please attach a listener in onCreate
```
onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)


        val sr_searchResults = srl_resuls as SearchResultLayout
        sr_searchResults.attachListener(this)
    }
```

**Custom Colors - colors.xml**
Simply set/change these colors in your colors.xml resource file

```xml
    Search results theme colors
       <color name="searchResultsBackground">#f2f2f2</color>
```
----------

If you would like more control over the styling and more colors please specify and i will push updates.