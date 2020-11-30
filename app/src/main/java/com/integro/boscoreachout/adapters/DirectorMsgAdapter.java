package com.integro.boscoreachout.adapters;

import android.content.Context;
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
import com.integro.boscoreachout.model.DirectorMsg;

import java.util.ArrayList;

public class DirectorMsgAdapter extends RecyclerView.Adapter<DirectorMsgAdapter.MyViewHolder> {
    Context context;
    ArrayList<DirectorMsg>directorMsgArrayList;

    public DirectorMsgAdapter(Context context, ArrayList<DirectorMsg> directorMsgArrayList) {
        this.context = context;
        this.directorMsgArrayList = directorMsgArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_director_msg,parent,false);
        return new DirectorMsgAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DirectorMsg directorMsg=directorMsgArrayList.get(position);

        holder.tvdmDescription.setText(directorMsg.getDescription());
        Glide.with(context)
                .load(directorMsg.getImage())
                .into(holder.ivdmImage);
    }

    @Override
    public int getItemCount() {
        return directorMsgArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewDirectorMsg;
        ImageView ivdmImage;
        TextView tvdmDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewDirectorMsg=itemView.findViewById(R.id.cr_DirectorMsg);
            ivdmImage=itemView.findViewById(R.id.iv_dmImage);
            tvdmDescription=itemView.findViewById(R.id.tv_dmDescription);
            //tvdmReadMore=itemView.findViewById(R.id.tv_dmReadMore);

        }
    }
}
