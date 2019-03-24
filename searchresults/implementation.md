# Google Search Results on Android for Thunderhead ONE  
  
This easy to use library will help you display google search results for Thunderhead ONE in your project.  
  
# How to use  
 
**To include SearchBar to your project:**  

   add this code to the the project level build.gradle file  
  
```gradle 
allprojects{ 
	repositories {  
		  flatDir {  
		    dirs 'libs'  
		}
	}  
}
```  

add **searchresults-debug.aar** to the app modules lib folder  

 add this code to the the app level build.gradle file  
  
```gradle  
dependencies {  
  implementation(name: 'searchresults-debug', ext: 'aar')
  //because aar files do not include nested dependencies you must also include
  implementation 'androidx.cardview:cardview:1.0.0'  
  implementation 'androidx.constraintlayout:constraintlayout:1.1.3'  
  implementation 'com.google.android.material:material:1.0.0'

  implementation 'com.squareup.retrofit2:retrofit:2.4.0'  
  implementation 'com.squareup.okhttp3:okhttp:3.10.0'  
  implementation 'com.google.code.gson:gson:2.8.2'  
  implementation 'com.squareup.retrofit2:converter-gson:2.4.0'  
  implementation 'com.squareup.okio:okio:1.14.0'  
  implementation "com.squareup.okhttp3:logging-interceptor:3.10.0"  
  implementation 'com.squareup.picasso:picasso:2.5.2'
}  
```  
  
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


**Optional**
----------
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
       <color name="search_result_background_color">reaplce with your value</color>  
	   <color name="search_result_seperator_color">reaplce with your value</color>  
	   <color name="search_result_list_item_title_text_color">reaplce with your value</color>  
	   <color name="search_result_list_item_url_text_color">reaplce with your value</color>
```
----------

If you would like more control over the styling and more colors please specify and i will push updates.