package com.integro.boscoreachout.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.demono.AutoScrollViewPager;
import com.integro.boscoreachout.R;
import com.integro.boscoreachout.adapters.NewsImagesAdapterVp;
import com.integro.boscoreachout.apis.ApiClients;
import com.integro.boscoreachout.apis.ApiServices;
import com.integro.boscoreachout.model.News;
import com.integro.boscoreachout.model.NewsImage;
import com.integro.boscoreachout.model.NewsImageList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailsActivity extends AppCompatActivity {
    private static final String TAG = "NewsDetailsActivity";

    String itemId;
    ArrayList<NewsImage> newsImagesArrayList;
    AutoScrollViewPager vpNewsImages;
    NewsImagesAdapterVp newsImagesAdapterVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        News news = (News) getIntent().getSerializableExtra("NEWS");

        newsImagesArrayList = new ArrayList<>();

        vpNewsImages=findViewById(R.id.vp_NewsImage);
        TextView tvTitleND = findViewById(R.id.tv_newstitle);
        TextView tvDateND=findViewById(R.id.tv_newsdate);
        TextView tvDiscriptionND = findViewById(R.id.tv_newsdescription);

        tvDateND.setText(news.getDate());
        tvTitleND.setText(news.getTitle());
        tvDiscriptionND.setText(news.getDescription());

        itemId=news.getId();

        getNewsImagesList();
    }
    public void getNewsImagesList(){
        Call<NewsImageList> newsImagesCall;
        newsImagesCall = ApiClients.getClients().create(ApiServices.class).getNewsImageLIst(itemId);
        newsImagesCall.enqueue(new Callback<NewsImageList>() {
            @Override
            public void onResponse(Call<NewsImageList> call, Response<NewsImageList> response) {
                if (response.isSuccessful()) {
                    if (response.body().getNewsImageArrayList() != null) {
                        int size = response.body().getNewsImageArrayList().size();
                        Log.d("response", "NewsImages" + size);
                        if (size > 0) {
                            newsImagesArrayList.addAll(response.body().getNewsImageArrayList());
                            newsImagesAdapterVp = new NewsImagesAdapterVp(getApplicationContext(), newsImagesArrayList);
                            vpNewsImages.startAutoScroll(3000);
                            vpNewsImages.setCycle(true);
                            vpNewsImages.setAdapter(newsImagesAdapterVp);
                            Log.i(TAG, "onResponse: " + newsImagesArrayList.size());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsImageList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onfailure:" + t.getMessage());
            }
        });
    }
}

