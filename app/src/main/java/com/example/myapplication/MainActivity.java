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


public class MainActivity extends AppCompatActivity {
    Button button;
    public int counter;
//    public long number;
    TextView textview;
    EditText input_space;
//    public CharSequence user_time_input;
//    public int user_time_input_int;
    //    CharSequence x;
//    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_space = (EditText)findViewById(R.id.user_input);
        button = (Button) findViewById(R.id.StartPause);
        textview = (TextView)findViewById(R.id.countdown_timer);
        textview.setText("Touch start to start timer :)");
        textview.setInputType(InputType.TYPE_CLASS_NUMBER);
//        String z = null;


        // Timer has been created in a text view
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CharSequence user_time_input = input_space.getText(); // we get text from here
                int user_time_input_int = Integer.parseInt(user_time_input.toString());
//                Log.d(null, "this is my number" + number);
                new CountDownTimer(user_time_input_int, 1000) {
                    public void onTick(long millisUntilFinished) {
//                        textview.setText(String.valueOf(counter));
                        textview.setText("Time Left: " + millisUntilFinished/1000);
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