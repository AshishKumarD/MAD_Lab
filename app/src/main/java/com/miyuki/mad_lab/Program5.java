package com.miyuki.mad_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Program5 extends AppCompatActivity {

    TextView txtCounter;
    int count=0;
    Handler customHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program5);
        txtCounter= (TextView)findViewById(R.id.counter);

    }

    public void start(View v){
        customHandler.postDelayed(updateTimerThread,0);
    }

    public void stop(View v){
        customHandler.removeCallbacks(updateTimerThread);
    }
    private final Runnable updateTimerThread =new Runnable() {
        @Override
        public void run() {
            txtCounter.setText(""+count);
            customHandler.postDelayed(this,1000);
            count++;
        }
    };
}