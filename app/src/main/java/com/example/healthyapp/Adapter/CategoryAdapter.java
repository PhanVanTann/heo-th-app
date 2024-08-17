package com.example.healthyapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyapp.Domain.CategoryDomain;
import com.example.healthyapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<CategoryDomain> items ;
    Context context;

    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate=LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cartegory,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.titleTxT.setText(items.get(position).getTitle());
         @SuppressLint("DiscouragedApi") int drawableResourceId=holder.itemView.getResources()
                .getIdentifier( items.get(position).getImgPath(),"drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(context)
//                .load(drawableResourceId)
//                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxT;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxT=itemView.findViewById(R.id.titleTxt);
            pic=itemView.findViewById(R.id.img);
        }
    }
}
