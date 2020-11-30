package com.integro.boscoreachout.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.integro.boscoreachout.R;
import com.integro.boscoreachout.adapters.NotificationAdapter;
import com.integro.boscoreachout.apis.ApiClients;
import com.integro.boscoreachout.apis.ApiServices;
import com.integro.boscoreachout.model.Notification;
import com.integro.boscoreachout.model.NotificationList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FragmentNotifications extends Fragment {
    ApiServices apiServices;
    RecyclerView rvnotification;
    LinearLayoutManager manager;
    NotificationAdapter adapter;
    ArrayList<Notification> notificationArrayList;
    Call<NotificationList> notificationListCall;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notifications, container, false);
        apiServices = ApiClients.getClients().create(ApiServices.class);
        rvnotification = view.findViewById(R.id.rv_notification);
        notificationArrayList = new ArrayList<>();
        manager = new LinearLayoutManager(getContext());
        rvnotification.setLayoutManager(new LinearLayoutManager(getContext()));
        rvnotification.setHasFixedSize(true);
        getNotificationList();
        return view;
    }
    public void getNotificationList() {

        String date = "2020-11-16 02:08:32";
        notificationListCall = apiServices.getNotificationList(date);
        notificationListCall.enqueue(new Callback<NotificationList>() {
            @Override
            public void onResponse(Call<NotificationList> call, Response<NotificationList> response) {
                if (response.isSuccessful()){
                    if (response.body().getSuccess() == 1){
                        int size=response.body().getNotificationArrayList().size();
                        if (size>0){
                            notificationArrayList.addAll(response.body().getNotificationArrayList());
                            adapter = new NotificationAdapter(getContext(), notificationArrayList);
                            rvnotification.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        else {
                            // showing message if size is 0
                            Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        //data not available
                        Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //failure api response
                    Toast.makeText(getContext(), "Something went wrong, try again", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<NotificationList> call, Throwable t) {

                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onfailure:" + t.getMessage());
            }
        });
    }
}