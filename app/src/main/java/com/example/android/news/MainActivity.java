package com.example.android.news;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int pageCount = Integer.parseInt(sharedPreferences.getString(getString(R.string.pref_news_count_key),getString(R.string.pref_news_count_default_value)));

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        NewsFragmentPagerAdapter adapter = new NewsFragmentPagerAdapter(this, getSupportFragmentManager(), pageCount);
        viewpager.setAdapter(adapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_setting:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(getString(R.string.pref_news_count_key))){
            int pageCount = Integer.parseInt(sharedPreferences.getString(getString(R.string.pref_news_count_key),getString(R.string.pref_news_count_default_value)));

            ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
            NewsFragmentPagerAdapter adapter = (NewsFragmentPagerAdapter)viewpager.getAdapter();
            if(adapter != null) {
                adapter.setPageCount(pageCount);
                adapter.notifyDataSetChanged();
                viewpager.setAdapter(adapter);
            }
            viewpager.setAdapter(adapter);


            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewpager);
        }
    }
}
