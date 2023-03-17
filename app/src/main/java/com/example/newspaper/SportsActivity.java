package com.example.newspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsActivity extends AppCompatActivity {
    String country = "in";
    String api = "fe12f5aeed634165b36c0c25fee962d0";
    Adapter adapter;
    String category = "sports";
    Toolbar toolbar;
    ImageButton back;
    TextView baseText;
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewOfEn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        recyclerViewOfEn = findViewById(R.id.recyclerViewOfEn);
        toolbar = findViewById(R.id.toolBar);
        back = findViewById(R.id.back);
        baseText = findViewById(R.id.baseText);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfEn.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new Adapter(SportsActivity.this,modelClassArrayList);
        recyclerViewOfEn.setAdapter(adapter);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baseText.setText(name);



        findNews();


    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<MainNewsModelClass>() {
            @Override
            public void onResponse(Call<MainNewsModelClass> call, Response<MainNewsModelClass> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNewsModelClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ""+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}