package com.example.android.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsListAdapter extends ArrayAdapter<NewsItem> {

    public NewsListAdapter(@NonNull Context context, @NonNull ArrayList<NewsItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){

        NewsItem currentNews = getItem(position);

        View listItemView = view;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.new_list_item, viewGroup, false);
        }

        TextView titleTextView = (TextView)listItemView.findViewById(R.id.title_textview);
        titleTextView.setText(currentNews.getTitle());
        TextView categoryTextView = (TextView)listItemView.findViewById(R.id.category_textview);
        categoryTextView.setText(currentNews.getCategory());
        TextView authorTextView = (TextView)listItemView.findViewById(R.id.author_textview);
        authorTextView.setText(currentNews.getAuthor());
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_textview);
        dateTextView.setText(currentNews.getDate());


        return listItemView;
    }


}
