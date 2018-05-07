package com.example.android.news;

public class NewsItem {
    private String mTitle;
    private String mCategory;
    private String mAuthor;
    private String mDate;
    private String mURL;

    public NewsItem(String title, String category, String author, String date, String url){
        this.mTitle = title;
        this.mCategory = category;
        this.mAuthor = author;
        this.mDate = date;
        this.mURL = url;
    }

    public String getTitle(){
        return this.mTitle;
    }

    public String getCategory(){
        return this.mCategory;
    }

    public String getAuthor(){ return this.mAuthor; }

    public String getDate() { return this.mDate; }

    public String getURL() { return this.mURL; }
}
