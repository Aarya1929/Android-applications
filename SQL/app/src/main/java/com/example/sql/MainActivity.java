package com.example.sql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b1,b2,b3,b4;
    database g;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);


        database g=new database(this);
        //SQLiteDatabase db=g.getReadableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=et1.getText().toString();
                String username1=et2.getText().toString();
                String password1=et3.getText().toString();
                if (name1.equals("")|| username1.equals("") || password1.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                        Boolean i=g.insert_data(name1,username1,password1);
                        if (i==true)
                        {
                            Toast.makeText(MainActivity.this,"Successful", Toast.LENGTH_SHORT).show();
                        }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor t=g.getinfo();
                if(t.getCount() ==0)
                {
                    Toast.makeText(MainActivity.this,"No data found",Toast.LENGTH_SHORT).show();
                }
            StringBuffer buffer=new StringBuffer();
            while(t.moveToNext())
            {
                buffer.append("Name::"+t.getString(1)+"\n");
                buffer.append("Username::"+t.getString(2)+"\n");
                buffer.append("Password::"+t.getString(3)+"\n\n\n");
            }
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("SignUp Users Data");
            builder.setMessage(buffer.toString());
            builder.show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String username=et2.getText().toString();
                String password=et3.getText().toString();
                Boolean i=g.update_data(name,username,password);
                if(i==true)
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Not Successful",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et2.getText().toString();
                Boolean i=g.delete_data(username);
                if(i==true)
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Not Successful",Toast.LENGTH_SHORT).show();
            }
        });
        };

    }
