package com.integro.boscoreachout.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.integro.boscoreachout.R;
import com.integro.boscoreachout.activities.NewsDetailsActivity;
import com.integro.boscoreachout.model.News;

import java.util.ArrayList;

public class NewsViewPagerAdapter  extends PagerAdapter {
    Context context;
    ArrayList<News> newsArrayList;
    LayoutInflater inflater;

    public NewsViewPagerAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView ivFullImage;
        TextView tvTitle,tvDescription;
        LinearLayout ll_News;
        News news=newsArrayList.get(position);

        View view = LayoutInflater.from(context).inflate(R.layout.card_view_pager, container, false);

        ivFullImage = (ImageView) view.findViewById(R.id.iv_image);
        tvTitle = view.findViewById(R.id.tv_titleVp);
        tvDescription=view.findViewById(R.id.tvDescriptionVp);
        ll_News=view.findViewById(R.id.ll_News);

        tvTitle.setText(newsArrayList.get(position).getTitle());
        tvDescription.setText(newsArrayList.get(position).getDescription());

        Glide.with(context)
                .load(newsArrayList.get(position).getImage())
                .into(ivFullImage);

        ((ViewPager) container).addView(view);

        ll_News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("NEWS", news);
                context.startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
