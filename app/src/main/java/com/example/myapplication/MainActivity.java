package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;


public class MainActivity extends AppCompatActivity {
    Button button;
    public int counter;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.StartPause);
        textview = (TextView)findViewById(R.id.countdown_timer);
        // Timer has been created in a text view
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(5000, 1000){
                    public void onTick(long millisUntilFinished){
                        textview.setText(String.valueOf(counter));
                        textview.setText("time left: " + millisUntilFinished /1000);
                        counter++;
                    }
                    public void onFinish() {
                        textview.setText("Finish");
                    }
                }.start();
            }
        });
    }
}