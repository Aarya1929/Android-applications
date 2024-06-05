package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void implicit_action(View view) {
        Uri url=Uri.parse("https://www.google.com");
        Intent intent=new Intent(Intent.ACTION_VIEW,url);
        startActivity(intent);
    }

    public void explicit_action(View view) {
        String name="Hello Java";
        int mData = 25;
        Intent intent=new Intent(MainActivity.this,Intent2.class);
        intent.putExtra("text",name);
        intent.putExtra("data",mData);
        startActivity(intent);
    }

}