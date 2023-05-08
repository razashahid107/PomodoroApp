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
    public int counter;
//    public long number;
    TextView textview;
    EditText input_space;
    EditText input_space_min;
    boolean timer_check = false;

    //    public CharSequence user_time_input;
//    public int user_time_input_int;
    //    CharSequence x;
//    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_space = (EditText)findViewById(R.id.user_input);
        input_space_min = (EditText)findViewById(R.id.user_input_min);
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
                CharSequence user_time_input_min = input_space_min.getText();
                int user_time_input_int = Integer.parseInt(user_time_input.toString());
                int user_time_input_int_min = Integer.parseInt(user_time_input_min.toString());

                if (timer_check){
                    Toast.makeText(getApplicationContext(),"A timer is alredy in place. Stop it to start a new one.", Toast.LENGTH_SHORT).show();
                }
                else {
                    new CountDownTimer((user_time_input_int_min * 60*1000)+user_time_input_int*1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            timer_check = true;
//                        textview.setText(String.valueOf(counter));
                            textview.setText("Time Left: " + millisUntilFinished/1000);
                            counter++;
                        }
                        public void onFinish() {
                            textview.setText("Finish");
                            timer_check = false;
                        }
                    }.start();
                }



            }
        });
    }
}