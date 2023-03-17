package com.example.newspaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;
    ArrayList<ModelSP> modelSPS = new ArrayList<>();

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_sample_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image = modelClassArrayList.get(position).getUrlToImage();
        String title = modelClassArrayList.get(position).getTitle();
        String author = modelClassArrayList.get(position).getAuthor();
        String time = modelClassArrayList.get(position).getTitle();
        String url= modelClassArrayList.get(position).getUrl();


                Picasso.get().load(image).into(holder.imageView);
                holder.title.setText(title);
                holder.author.setText(author);
                holder.time.setText(time);



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WebViewActivity.class);
                intent.putExtra("url",url);
                context.startActivity(intent);
            }
        });
    }

    private void LoadData() {
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,author,time;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mainImage);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
