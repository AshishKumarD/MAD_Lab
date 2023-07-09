package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void program1(View v){
        Intent i = new Intent(MainActivity.this, Program1.class);
        startActivity(i);
    }
    public void program2(View v){
        Intent i = new Intent(MainActivity.this, Program2.class);
        startActivity(i);
    }
    public void program3(View v){
        Intent i = new Intent(MainActivity.this, Program3.class);
        startActivity(i);
    }
    public void program4(View v){
        Intent i = new Intent(MainActivity.this, Program4.class);
        startActivity(i);
    }
    public void program5(View v){
        Intent i = new Intent(MainActivity.this, Program5.class);
        startActivity(i);
    }
    public void program6(View v){
        Intent i = new Intent(MainActivity.this, Program6.class);
        startActivity(i);
    }

    public void program7(View v){
        Intent i = new Intent(MainActivity.this, Program7.class);
        startActivity(i);
    }

    public void program8(View v){
        Intent i = new Intent(MainActivity.this, Program8.class);
        startActivity(i);
    }
}