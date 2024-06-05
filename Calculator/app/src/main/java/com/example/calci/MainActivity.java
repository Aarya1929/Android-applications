package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Defining the Views
    EditText ed1;
    EditText ed2;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        tx = (TextView) findViewById(R.id.tx);

        // set a listener
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;
        String oper = "";

        // check if the fields are empty
        if (TextUtils.isEmpty(ed1.getText().toString()) || TextUtils.isEmpty(ed2.getText().toString()))
            return;

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(ed1.getText().toString());
        num2 = Float.parseFloat(ed2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId())
        {
            case R.id.b1:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.b2:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.b3:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.b4:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }
        // form the output line
        tx.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}