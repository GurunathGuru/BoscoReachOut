package com.integro.boscoreachout.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.integro.boscoreachout.R;
import com.integro.boscoreachout.adapters.OurProjectsAdapter;
import com.integro.boscoreachout.apis.ApiClients;
import com.integro.boscoreachout.apis.ApiServices;
import com.integro.boscoreachout.model.OurProjects;
import com.integro.boscoreachout.model.OurProjectsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OurProjectsActivity extends AppCompatActivity {
    ApiServices apiServices;
    RecyclerView rvOurProjects;
    LinearLayoutManager manager;
    OurProjectsAdapter ourProjectsAdapter;
    ArrayList<OurProjects> ourProjectsArrayList;
    Call<OurProjectsList>ourProjectsListCall ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_projects);

        apiServices = ApiClients.getClients().create(ApiServices.class);
        rvOurProjects=findViewById(R.id.rv_OurProjects);
        manager = new LinearLayoutManager(this);
        rvOurProjects.setLayoutManager(manager);
        ourProjectsArrayList = new ArrayList<>();
        getOurProjects();
    }
    public void getOurProjects(){
        String date = "2020-07-06 01:59:02";
        ourProjectsListCall = apiServices.getOueProjectsList(date);
        ourProjectsListCall.enqueue(new Callback<OurProjectsList>() {
            @Override
            public void onResponse(Call<OurProjectsList> call, Response<OurProjectsList> response) {
                if (response.isSuccessful()) {
                    if (response.body().getOurProjectsArrayList() != null) {
                        int size = response.body().getOurProjectsArrayList().size();
                        Log.d("RESPONSE", "news Size " + size);
                        ourProjectsArrayList.addAll(response.body().getOurProjectsArrayList());
                        if (ourProjectsArrayList.size() > 0) {
                            ourProjectsAdapter = new OurProjectsAdapter(getApplicationContext(),ourProjectsArrayList);
                            rvOurProjects.setAdapter(ourProjectsAdapter);
                        } else {
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Something went wrong, try again", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<OurProjectsList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onfailure:" + t.getMessage());

            }
        });

    }
    }

