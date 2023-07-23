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
    public int counter = 0; // used to record time
    TextView textview;
    EditText input_space;
    TextView textview_sample;
    EditText input_space_min;
    boolean timer_check = true; // determines whether timer is running or not. True by default so timer can run

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
                // following condition exists for the second time when button is clicked
                if (counter > 0 && timer_check == true) {
                    timer_check = false;
                } else if (counter > 0 && timer_check == false) {
                    timer_check = true;
                }

                // Access user inputs for timer duration
                int user_time_input_int = Integer.parseInt(input_space.getText().toString());
                int user_time_input_int_min = Integer.parseInt(input_space_min.getText().toString());
                
                // Use inputs from user to input time
                counter = (user_time_input_int_min * 60 * 1000) + (user_time_input_int * 1000); 

                new CountDownTimer(counter, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if (timer_check) {
                            button.setText("END");
                            textview.setText("Time Left: " + millisUntilFinished / 1000);
                            counter -= 1000;
                        } 
                        else { // if timer_check=false run cancel()
                            button.setText("START AGAIN"); // change text of button to Start
                            cancel();
                            onFinish();
                        }
                    }
                    public void onFinish() {
                        textview.setText("Timer Ended");
                    }
                }.start();
            }
        });
    }
}