package com.integro.boscoreachout.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.integro.boscoreachout.R;
import com.integro.boscoreachout.adapters.DirectorMsgAdapter;
import com.integro.boscoreachout.apis.ApiClients;
import com.integro.boscoreachout.apis.ApiServices;
import com.integro.boscoreachout.model.DirectorMsg;
import com.integro.boscoreachout.model.DirectorMsgList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DirectorMsgActivity extends AppCompatActivity {

    ApiServices apiServices;
    RecyclerView rvDirectorMsg;
    LinearLayoutManager manager;
    DirectorMsgAdapter directorMsgAdapter;
    ArrayList<DirectorMsg>directorMsgArrayList ;
    Call<DirectorMsgList>directorMsgListCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_msg);

        apiServices = ApiClients.getClients().create(ApiServices.class);
        rvDirectorMsg=findViewById(R.id.rv_DirectorMsg);
        manager = new LinearLayoutManager(this);
        rvDirectorMsg.setLayoutManager(manager);
        directorMsgArrayList = new ArrayList<>();
        getDirectorMsgList();
    }
    public void getDirectorMsgList(){
        String date = "2020-07-06 01:59:02";
        directorMsgListCall = apiServices.getDirectorMsgList(date);
        directorMsgListCall.enqueue(new Callback<DirectorMsgList>() {
            @Override
            public void onResponse(Call<DirectorMsgList> call, Response<DirectorMsgList> response) {
                if (response.isSuccessful()) {
                    if (response.body().getDirectorMsgArrayList() != null) {
                        int size = response.body().getDirectorMsgArrayList().size();
                        Log.d("RESPONSE", "news Size " + size);
                        directorMsgArrayList.addAll(response.body().getDirectorMsgArrayList());
                        if (directorMsgArrayList.size() > 0) {
                            directorMsgAdapter = new DirectorMsgAdapter(getApplicationContext(),directorMsgArrayList);
                            rvDirectorMsg.setAdapter(directorMsgAdapter);
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
            public void onFailure(Call<DirectorMsgList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onfailure:" + t.getMessage());

            }
        });

    }
}

