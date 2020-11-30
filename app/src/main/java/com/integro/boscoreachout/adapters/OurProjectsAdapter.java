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
import com.integro.boscoreachout.model.OurProjects;

import java.util.ArrayList;

public class OurProjectsAdapter  extends RecyclerView.Adapter<OurProjectsAdapter.MyViewHolder> {

    Context context;
    ArrayList<OurProjects>ourProjectsArrayList;

    public OurProjectsAdapter(Context context, ArrayList<OurProjects> ourProjectsArrayList) {
        this.context = context;
        this.ourProjectsArrayList = ourProjectsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_our_projects,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final OurProjects ourProjects=ourProjectsArrayList.get(position);


        holder.tvopTitle.setText(ourProjects.getTitle());
        holder.tvopDescription.setText(ourProjects.getDescription());
        Glide.with(context)
                .load(ourProjects.getImage())
                .into(holder.ivopImage);

    }

    @Override
    public int getItemCount() {
        return ourProjectsArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewOurProjects;
        ImageView ivopImage;
        TextView tvopTitle,tvopDescription,tvopReadMore;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewOurProjects=itemView.findViewById(R.id.cr_OurProjects);
            ivopImage=itemView.findViewById(R.id.iv_opImage);
            tvopTitle=itemView.findViewById(R.id.tv_opTitle);
            tvopDescription=itemView.findViewById(R.id.tv_opDescription);
            //tvlmReadMore=itemView.findViewById(R.id.tv_lmReadMore);

        }
    }
}
