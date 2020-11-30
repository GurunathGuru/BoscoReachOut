package com.integro.boscoreachout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.boscoreachout.R;
import com.integro.boscoreachout.model.Notification;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    Context context;
    ArrayList<Notification>notificationArrayList;

    public NotificationAdapter(Context context, ArrayList<Notification> notificationArrayList) {
        this.context = context;
        this.notificationArrayList = notificationArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_notification, null);
        RecyclerView.LayoutParams lp = new RecyclerView
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Notification notification = notificationArrayList.get(position);
        holder.tvDate.setText(notification.getDate());
        holder.tvTitle.setText(notification.getTitle());
        holder.tvDescription.setText(notification.getDescription());

    }

    @Override
    public int getItemCount() {
        return notificationArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewNotification;
        TextView tvDate, tvTitle, tvDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewNotification = itemView.findViewById(R.id.cr_notification);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);

        }
    }

}
