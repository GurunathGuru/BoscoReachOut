package com.integro.boscoreachout.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.boscoreachout.R;
import com.integro.boscoreachout.activities.NewsDetailsActivity;
import com.integro.boscoreachout.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context context;
    ArrayList<News>newsArrayList;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_news,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News news=newsArrayList.get(position);

        Glide.with(context)
                .load(news.getImage())
                .into(holder.ivImage);

        holder.tvDate.setText(news.getDate());
        holder.tvTitle.setText(news.getTitle());
        holder.tvDescription.setText(news.getDescription());

        holder.cardViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, NewsDetailsActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("NEWS",news);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewNews;
        ImageView ivImage;
        TextView tvTitle,tvDate,tvDescription,tvReadMore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewNews=itemView.findViewById(R.id.cr_news);
            ivImage=itemView.findViewById(R.id.iv_news);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvDate=itemView.findViewById(R.id.tv_date);
            tvDescription=itemView.findViewById(R.id.tv_description);
            tvReadMore=itemView.findViewById(R.id.tv_ReadMore);
        }
    }

}
