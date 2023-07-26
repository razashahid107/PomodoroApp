package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    Button button;
    private CountDownTimer break_timer = null;
    private CountDownTimer timer = null;
    public int counter = 0; // used to record time
    TextView textview;
    EditText input_space_sec;
    EditText input_space_min;
    TextView textview_sample;

    // determines whether timer is running or not. True by default so timer can run
    boolean timer_running = false;
    boolean break_check = false;
    // Function to switch backgroud color
    public void updateBackgroundColor(boolean isTimerRunning) {
        int colorResId = isTimerRunning ? R.color.colorTimerBackground : R.color.colorBreakBackground;
        int color = ContextCompat.getColor(this, colorResId);
        findViewById(R.id.activity_main_layout).setBackgroundColor(color);
    }
    // Start timer
    public void startTimer(int total_time) {
        button.setText("Start Break");
        timer = new CountDownTimer(total_time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int totalSecondsLeft = (int) millisUntilFinished / 1000;
                int minutesLeft = totalSecondsLeft / 60;
                int secondsLeft = totalSecondsLeft % 60;
                if (secondsLeft < 10) {
                    textview.setText(minutesLeft + ":" + 0 + secondsLeft);
                } else {
                    textview.setText(minutesLeft + ":" + secondsLeft);
                }
            }

            @Override
            public void onFinish() {
                textview.setText("0:00");
            }
        }.start();
    }
    // Break
    public void Break(int time) {
        button.setText("End Break");
        break_timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int totalSecondsLeft = (int) millisUntilFinished / 1000;
                int minutesLeft = totalSecondsLeft / 60;
                int secondsLeft = totalSecondsLeft % 60;
                if (secondsLeft < 10) {
                    textview.setText(minutesLeft + ":" + 0 + secondsLeft);
                } else {
                    textview.setText(minutesLeft + ":" + secondsLeft);
                }
            }

            @Override
            public void onFinish() {
                textview.setText("0:00");
            }
        }.start();
    }

    // All the functions used in the following code have been pre declared above
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_space_sec = (EditText) findViewById(R.id.user_input_second);
        input_space_min = (EditText) findViewById(R.id.user_input_min);
        button = (Button) findViewById(R.id.StartPause);
        textview = (TextView) findViewById(R.id.countdown_timer); // Timer exists in textview
        textview.setInputType(InputType.TYPE_CLASS_NUMBER);
        textview.setText("00:00");
        button.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        button.setTextColor(Color.BLACK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!timer_running) { // if timer is not running
                    // start the timer
                    updateBackgroundColor(true); // change background
                    // if the CountDownTimber object break_timer is not null 
                    // it means that the timer has already begun therefore the break need to be closed
                    if (break_timer != null) {
                        break_timer.cancel();
                    }
                    int user_time_input_sec = Integer.parseInt(input_space_sec.getText().toString());
                    int user_time_input_min = Integer.parseInt(input_space_min.getText().toString());
                    int total_time = ((user_time_input_sec) + (user_time_input_min * 60)) * 1000;
                    timer_running = true;
                    startTimer(total_time);
                } else if (timer_running) { // if timer is running and user still clicks button
                    updateBackgroundColor(false); // change background
                    // if the CountDownTimer object timer is not null
                    // it means that the timer object has happened and if we have entered this part of the if statement we will be executing break soon
                    // hence the timer needs to be cancelled
                    if (timer != null) {
                        timer.cancel();
                    }
                    timer_running = false;
                    Break(300 * 1000); // Hard code breaks to be 5 minutes only 
                    button.setText("Start Timer");
                }
            }
        });
    }

}