package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Program2 extends AppCompatActivity {

    EditText e1,e2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program2);
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        tv = findViewById(R.id.output);
    }
    public void add(View v){
        int a1=Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result=a1+a2;
        tv.setText(""+result);
    }
    public void sub(View v){
        int a1=Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result=a1-a2;
        tv.setText(""+result);
    }
    public void mul(View v){
        int a1=Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result=a1*a2;
        tv.setText(""+result);
    }
    public void div(View v){
        float a1=Integer.parseInt(e1.getText().toString());
        float a2= Integer.parseInt(e2.getText().toString());
        float result=a1/a2;
        tv.setText(""+result);
    }
}
