package com.example.android.news;

public class NewsItem {
    private String mTitle;
    private String mDate;
    private String mURL;

    public NewsItem(String title, String date, String url){
        this.mTitle = title;
        this.mDate = date;
        this.mURL = url;
    }

    public String getTitle(){ return this.mTitle; }

    public String getDate() { return this.mDate; }

    public String getURL() { return this.mURL; }
}
