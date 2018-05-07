package com.example.android.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

//import java.util.ArrayList;
import java.util.List;

public class NewsAsyncTaskLoader extends AsyncTaskLoader<List<NewsItem>> {
    private String mUrl = "";

    public NewsAsyncTaskLoader(Context context, String url){
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
    }
    @Override
    public List<NewsItem> loadInBackground() {
        if (this.mUrl == null){
            return null;
        }
        List<NewsItem> newsList = QueryUtils.fetchNewsData(this.mUrl);
        return newsList;
    }
}
