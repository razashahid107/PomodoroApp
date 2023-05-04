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
//    CharSequence x;
//    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.StartPause);
        textview = (TextView)findViewById(R.id.countdown_timer);
        textview.setText("Touch start to start timer :)");
        textview.setInputType(InputType.TYPE_CLASS_NUMBER);
//        String z = null;


        // Timer has been created in a text view
        button.setOnClickListener(new View.OnClickListener() {
//            public CharSequence x = textview.getText();
//            public int number = Integer.parseInt(x);
            @Override
            public void onClick(View view) {

//                Log.d(null, "this is my number" + number);
                new CountDownTimer(10000, 1000) {
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