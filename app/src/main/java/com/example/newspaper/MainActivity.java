package com.example.newspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CardView entertainment,science,sports,technology;
    TextView entext,sptext,sctext,tetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        entertainment = findViewById(R.id.entertainment);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        technology = findViewById(R.id.technology);
        entext = findViewById(R.id.entext);
        sptext = findViewById(R.id.sptext);
        sctext = findViewById(R.id.sctext);
        tetext = findViewById(R.id.tetext);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.Open_drawer,R.string.Close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.bringToFront();
        
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EntertainmentActivity.class);
                String newsType = entext.getText().toString();
                intent.putExtra("name",newsType);
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SportsActivity.class);
                String newsType = sptext.getText().toString();
                intent.putExtra("name",newsType);
                startActivity(intent);
            }
        });
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ScienceActivity.class);
                String newsType = sctext.getText().toString();
                intent.putExtra("name",newsType);
                startActivity(intent);
            }
        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TechnologyActivity.class);
                String newsType = tetext.getText().toString();
                intent.putExtra("name",newsType);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}