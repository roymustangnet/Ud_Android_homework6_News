package com.example.android.news;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {
    public NewsFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    private Context mContext;
    @Override
    public Fragment getItem(int position) {
        String url = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=166f9f73-2fb8-4a05-8ccb-b9c1491c473b";
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        switch (position){
            case 0:
                args.putString("url", url);
                break;
            case 1:
                args.putString("url", url);
                break;
            case 2:
                args.putString("url", url);
                break;
            case 3:
                args.putString("url", url);
                break;
            case 4:
                args.putString("url", url);
                break;
        }
        args.putInt("loaderId", position);
        fragment.setArguments(args);
        return fragment;
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
            return mContext.getString(R.string.category_option);
        } else if (position == 2) {
            return mContext.getString(R.string.category_sport);
        } else if (position == 3){
            return mContext.getString(R.string.category_culture);
        } else {
            return mContext.getString(R.string.category_liftstyle);
        }
    }
}
