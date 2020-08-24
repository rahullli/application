package com.example.competetiveprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;
    private AssetManager assetManager;//
    ArrayList<String> titleArrayList;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;     // mContext ko yaha pr initialize kiya h //
        assetManager = getAssets();
       titleArrayList = new ArrayList<String>();

        titleArrayList.add(Constants.GETTERS);
        titleArrayList.add(Constants.HERITANCE);
        titleArrayList.add(Constants.JAVA);
        titleArrayList.add(Constants.THREADING);
        titleArrayList.add(Constants.INHERITANCE);
        titleArrayList.add(Constants.POLYMORPHISM);
        titleArrayList.add(Constants.SETTERS);







        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);       // isko bhi apn ne initialize kiya h //

        mRecyclerView.setHasFixedSize(true);// iska kya mtlb h //

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));                  // kis m dunga -> linear layout m aur

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position){


                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",titleArrayList.get(position));// key value pair h ye basically //

                startActivity(desIntent);

                Toast.makeText(mContext, "clicked"+titleArrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        mRecyclerView.setAdapter(adapter);
    }
}