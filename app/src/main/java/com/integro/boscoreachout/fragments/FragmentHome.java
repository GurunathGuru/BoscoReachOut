package com.integro.boscoreachout.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.demono.AutoScrollViewPager;
import com.integro.boscoreachout.R;
import com.integro.boscoreachout.activities.AboutUsActivity;
import com.integro.boscoreachout.activities.OurProjectsActivity;
import com.integro.boscoreachout.adapters.NewsViewPagerAdapter;
import com.integro.boscoreachout.apis.ApiClients;
import com.integro.boscoreachout.apis.ApiServices;
import com.integro.boscoreachout.model.News;
import com.integro.boscoreachout.model.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    TextView tvAbouotUs, tvOurProjects, tvSupportCenter;
    LinearLayout llDonate;

    private ApiServices apiServices;
    private AutoScrollViewPager viewPagerNews;
    private ArrayList<News> newsArrayList;
    Call<NewsList> newsListCall;
    private NewsViewPagerAdapter newsViewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        apiServices = ApiClients.getClients().create(ApiServices.class);
        newsArrayList = new ArrayList<>();

        viewPagerNews = view.findViewById(R.id.au_news);
        tvAbouotUs = view.findViewById(R.id.tv_aboutus);
        llDonate = view.findViewById(R.id.ll_donate);
        tvOurProjects = view.findViewById(R.id.tv_ourprojects);
        tvSupportCenter = view.findViewById(R.id.tv_supportcenter);

        tvOurProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOurProjects = new Intent(getContext(), OurProjectsActivity.class);
                startActivity(intentOurProjects);
            }
        });
        tvAbouotUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAboutUs=new Intent(getContext(), AboutUsActivity.class);
                startActivity(intentAboutUs);
            }
        });
        getNewsList();
        return view;
    }

    public void getNewsList() {
        String date = "2020-11-16 02:01:41";
        newsListCall = apiServices.getNewsList(date);
        newsListCall.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                //checking response success or not
                if (response.isSuccessful()) {
                    //success api response

                    //response contains data or not
                    if (response.body().getSuccess() == 1) {
                        //data available

                        //getting the size of the arraylist
                        int size = response.body().getNewsArrayList().size();

                        //checking size is 0 or not
                        if (size > 0) {
                            newsArrayList.addAll(response.body().getNewsArrayList());
                            newsViewPagerAdapter = new NewsViewPagerAdapter(getContext(), newsArrayList);
                            viewPagerNews.setAdapter(newsViewPagerAdapter);
                            viewPagerNews.startAutoScroll(3000);
                            viewPagerNews.setCycle(true);

                        } else {
                            // showing message if size is 0
                            Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        //data not available
                        Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}