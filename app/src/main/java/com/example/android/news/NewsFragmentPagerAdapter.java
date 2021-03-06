package com.example.android.news;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class NewsFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final String BASE_URL = "https://content.guardianapis.com/search";
    private Integer mPageCount = 10;
    public NewsFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public void setPageCount(int pageCount){
        this.mPageCount = pageCount;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public NewsFragmentPagerAdapter(Context context, FragmentManager fm, int pageCount) {
        super(fm);
        mContext = context;
        this.mPageCount = pageCount;
    }
    private Context mContext;
    @Override
    public Fragment getItem(int position) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        String section = "";
        switch (position){
            case 0:
                section = mContext.getString(R.string.category_news);
                break;
            case 1:
                section = mContext.getString(R.string.category_politics);
                break;
            case 2:
                section = mContext.getString(R.string.category_sport);
                break;
            case 3:
                section = mContext.getString(R.string.category_culture);
                break;
            case 4:
                section = mContext.getString(R.string.category_business);
                break;
        }
        args.putString("url", getUrl(section));
        args.putInt("loaderId", position);
        fragment.setArguments(args);
        return fragment;
    }

    private String getUrl(String section) {
        Uri baseUri = Uri.parse(BASE_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.appendQueryParameter("section", section);
        uriBuilder.appendQueryParameter("format", "json");
        uriBuilder.appendQueryParameter("api-key", "test");
        uriBuilder.appendQueryParameter("page-size", this.mPageCount.toString());


        return uriBuilder.toString();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_news);
        } else if (position == 1) {
            return mContext.getString(R.string.category_politics);
        } else if (position == 2) {
            return mContext.getString(R.string.category_sport);
        } else if (position == 3){
            return mContext.getString(R.string.category_culture);
        } else {
            return mContext.getString(R.string.category_business);
        }
    }


}
