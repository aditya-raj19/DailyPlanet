package com.example.dailyplanet;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Modelclass> list;

    public Adapter(Context context, ArrayList<Modelclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context,WebView.class);
              intent.putExtra("url" ,list.get(holder.getAdapterPosition()).getUrl());
               context.startActivity(intent);
           }
       });
      holder.mtime.setText("Published At:-"+ list.get(position).getPublishedAt());
      holder.mauthor.setText(list.get(position).getAuthor());
      holder.mheading.setText(list.get(position).getTitle());
      holder.mcontent.setText(list.get(position).getDescription());
      Glide.with(context).load(list.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mauthor,mcategory,mtime,mcontent;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mauthor=itemView.findViewById(R.id.author);
            mheading=itemView.findViewById(R.id.mainheading);
            mtime=itemView.findViewById(R.id.time);
            mcontent=itemView.findViewById(R.id.content);

            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
    }
}}
