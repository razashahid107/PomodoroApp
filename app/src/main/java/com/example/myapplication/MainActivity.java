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

    boolean timer_running = false; // determines whether timer is running or not. True by default so timer can run
    boolean break_check = false;

    public void updateBackgroundColor(boolean isTimerRunning) {
        int colorResId = isTimerRunning ? R.color.colorTimerBackground : R.color.colorBreakBackground;
        int color = ContextCompat.getColor(this, colorResId);
//        Object colorFrom = null;
//        Object colorTo = null;
//        ObjectAnimator colorAnimation = ObjectAnimator.ofObject((Object) findViewById(R.id.activity_main_layout), "backgroundColor", new ArgbEvaluator(), colorFrom, colorTo);
//        colorAnimation.setDuration(1000); // Adjust the duration of the animation as per your preference (in milliseconds)
//        colorAnimation.start();
        findViewById(R.id.activity_main_layout).setBackgroundColor(color);
    }

    public void startTimer(int total_time){
        button.setText("Start Break");
        timer = new CountDownTimer(total_time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int totalSecondsLeft = (int) millisUntilFinished / 1000;
                int minutesLeft = totalSecondsLeft / 60;
                int secondsLeft = totalSecondsLeft % 60;
                if (secondsLeft < 10){
                    textview.setText(minutesLeft + ":" + 0 +secondsLeft);
                }
                else{
                    textview.setText(minutesLeft + ":" + secondsLeft);
                }
            }
            @Override
            public void onFinish() {
                textview.setText("Timer ended");
            }
        }.start();
    }
    public void Break(int time){
        button.setText("End Break");
        break_timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int totalSecondsLeft = (int) millisUntilFinished / 1000;
                int minutesLeft = totalSecondsLeft / 60;
                int secondsLeft = totalSecondsLeft % 60;
                if (secondsLeft < 10){
                    textview.setText(minutesLeft + ":" + 0 +secondsLeft);
                }
                else{
                    textview.setText(minutesLeft + ":" + secondsLeft);
                }
            }
            @Override
            public void onFinish() {
                textview.setText("Break ended");
            }
        }.start();
    }

//    public void Break(){
//        Log.d("Hey","hey there");
//        new CountDownTimer(300000, 1000) {
//            public void onTick(long millisUntilFinished) {
//                if (timer_check) {
//                    Log.d("Hey","this ran");
//
//                    button.setText("END BREAK");
//                    textview.setText("Time Left: " + millisUntilFinished / 1000);
//                    counter -= 1000;
////                            Break();
//                }
//                else { // if timer_check=false run cancel()
//                    button.setText("START TIMER"); // change text of button to Start
////                    cancel();
//                    onFinish();
//
//                }
//            }
//            public void onFinish() {
//                onCreate(new Bundle());
////                textview.setText("Timer Ended");
//            }
//        }.start();
//    }
//    public void startBreakTimer() {
//        if (!break_check){
//            button.setText("START TIMER");
//            break_timer.cancel();
//        }
//        int breakDuration = 5 * 60 * 1000; // 5 minutes in milliseconds
//        break_timer = new CountDownTimer(breakDuration, 1000) {
//            public void onTick(long millisUntilFinished) {
//                button.setText("END BREAK");
//                textview.setText("Break Time Left: " + millisUntilFinished / 1000);
//            }
//            public void onFinish() {
//                button.setText("START TIMER");
//                textview.setText("Break Ended");
//            }
//        }.start();
//    }

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

//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // break checks
//                if (break_check){ // this means the break is going on already and user wants it to end
//                    break_check = false;
//                    startBreakTimer();
//                }
//                // following condition exists for the second time when button is clicked
//                if (counter > 0 && timer_check == true) {
//                    Log.d("COUNTER", "counter is:" + counter);
//                    timer_check = false;
//                } else if (counter > 0 && timer_check == false) {
//                    timer_check = true;
//                }
//
//                // Access user inputs for timer duration
//                int user_time_input_int = Integer.parseInt(input_space.getText().toString());
//                int user_time_input_int_min = Integer.parseInt(input_space_min.getText().toString());
//
//                // Use inputs from user to input time
//                counter = (user_time_input_int_min * 60 * 1000) + (user_time_input_int * 1000);
//
//                timer = new CountDownTimer(counter, 1000) {
//                    public void onTick(long millisUntilFinished) {
//                        if (timer_check) {
//                            button.setText("END");
//                            textview.setText("Time Left: " + millisUntilFinished / 1000);
//                            counter -= 1000;
////                            Break();
//                        }
//                        else { // if timer_check=false run cancel()
//                            button.setText("START AGAIN"); // change text of button to Start
//                            textview.setText("Timer Ended");
//                            cancel();
//                        }
//                    }
//                    public void onFinish() {
////                        textview.setText("Timer Ended");
//                        break_check=true;
//                        startBreakTimer(); // Start the break timer automatically after the main timer ends
//
//                    }
//                }.start();

                if (!timer_running){ // if timer is not running
                    // start the timer
                    updateBackgroundColor(true); // change background

                    if(break_timer!=null){
                        break_timer.cancel();
                    }
                    int user_time_input_sec = Integer.parseInt(input_space_sec.getText().toString());
                    int user_time_input_min = Integer.parseInt(input_space_min.getText().toString());
                    int total_time = ((user_time_input_sec) + (user_time_input_min * 60)) * 1000;
                    timer_running = true;
                    startTimer(total_time);
                } else if (timer_running) { // if user is clicking button despite timer running
                    updateBackgroundColor(false);
                    if (timer!=null){
                        timer.cancel();
                    }
                    timer_running = false;
                    Break(300*1000);
//                    break_timer.cancel();
                    button.setText("Start Timer");
                }


                // Access user input


            }
        });
    }

}