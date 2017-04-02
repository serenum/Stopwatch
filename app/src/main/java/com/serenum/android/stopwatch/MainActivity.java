package com.serenum.android.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int seconds;
    public boolean running;
    public boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.stopwatch_display);
        final Handler secondPeriod = new Handler();
        secondPeriod.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int min = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, min, sec);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                secondPeriod.postDelayed(this, 1000);
            }
        });
    }
}
