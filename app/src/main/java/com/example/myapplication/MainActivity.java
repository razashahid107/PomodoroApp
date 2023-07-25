package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.os.CountDownTimer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    private CountDownTimer break_timer;
    private CountDownTimer timer;


    public int counter = 0; // used to record time
    TextView textview;
    EditText input_space;
    TextView textview_sample;
    EditText input_space_min;
    boolean timer_check = true; // determines whether timer is running or not. True by default so timer can run
    boolean break_check = false;

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
    public void startBreakTimer() {
        if (!break_check){
            button.setText("START TIMER");
            break_timer.cancel();
        }
        int breakDuration = 5 * 60 * 1000; // 5 minutes in milliseconds
        break_timer = new CountDownTimer(breakDuration, 1000) {
            public void onTick(long millisUntilFinished) {
                button.setText("END BREAK");
                textview.setText("Break Time Left: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                button.setText("START TIMER");
                textview.setText("Break Ended");
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_space = (EditText) findViewById(R.id.user_input);
        input_space_min = (EditText) findViewById(R.id.user_input_min);
        button = (Button) findViewById(R.id.StartPause);
        textview = (TextView) findViewById(R.id.countdown_timer); // Timer exists in textview
        textview.setText("Time Left: 300");
        textview.setInputType(InputType.TYPE_CLASS_NUMBER);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // break checks
                if (break_check){ // this means the break is going on already and user wants it to end
                    break_check = false;
                    startBreakTimer();
                }
                // following condition exists for the second time when button is clicked
                if (counter > 0 && timer_check == true) {
                    Log.d("COUNTER", "counter is:" + counter);
                    timer_check = false;
                } else if (counter > 0 && timer_check == false) {
                    timer_check = true;
                }

                // Access user inputs for timer duration
                int user_time_input_int = Integer.parseInt(input_space.getText().toString());
                int user_time_input_int_min = Integer.parseInt(input_space_min.getText().toString());
                
                // Use inputs from user to input time
                counter = (user_time_input_int_min * 60 * 1000) + (user_time_input_int * 1000); 

                timer = new CountDownTimer(counter, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if (timer_check) {
                            button.setText("END");
                            textview.setText("Time Left: " + millisUntilFinished / 1000);
                            counter -= 1000;
//                            Break();
                        } 
                        else { // if timer_check=false run cancel()
                            button.setText("START AGAIN"); // change text of button to Start
                            textview.setText("Timer Ended");
                            cancel();
                        }
                    }
                    public void onFinish() {
//                        textview.setText("Timer Ended");
                        break_check=true;
                        startBreakTimer(); // Start the break timer automatically after the main timer ends

                    }
                }.start();
            }
        });
    }
}