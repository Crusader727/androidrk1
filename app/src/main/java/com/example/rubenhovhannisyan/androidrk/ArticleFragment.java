package com.example.rubenhovhannisyan.androidrk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

    public ArticleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final LinearLayout view = (LinearLayout) inflater.inflate(R.layout.fragment_article, container, false);
        final Bundle bundle = getArguments();

        TextView titleView = view.findViewById(R.id.title);
        TextView dateView = view.findViewById(R.id.date);
        TextView contentView = view.findViewById(R.id.content);

        titleView.setText(bundle.getString("title"));
        dateView.setText(bundle.getString("date"));
        contentView.setText(bundle.getString("content"));

        return view;
    }
}
