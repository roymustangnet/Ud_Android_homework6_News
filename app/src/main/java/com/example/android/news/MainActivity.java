package com.example.android.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity{

    public static final String LOG_TAG = MainActivity.class.getName();

    String url = "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=166f9f73-2fb8-4a05-8ccb-b9c1491c473b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        NewsFragmentPagerAdapter adapter = new NewsFragmentPagerAdapter(this, getSupportFragmentManager());
        viewpager.setAdapter(adapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);
    }

}
