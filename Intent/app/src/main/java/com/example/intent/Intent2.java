package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Intent2 extends AppCompatActivity {

    private TextView Intent_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        Intent_text=findViewById(R.id.intent_text);

        Intent intent = getIntent();

        if (intent !=null){
            if (intent.hasExtra("text")){
                String text=intent.getStringExtra("text");
                Intent_text.setText(text);
            }
        }
    }
}