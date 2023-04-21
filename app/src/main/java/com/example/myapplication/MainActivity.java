package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.app.AlertDialog;
import android.content.DialogInterface;


import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    public int counter;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.StartPause);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This button was clicked", Toast.LENGTH_SHORT).show();
            }
        });
//        textview = (TextView) findViewById(R.id.countdown_timer);
//        // Timer has been created in a text view
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new CountDownTimer(30000, 1000) {
//                    public void onTick(long millisUntilFinished) {
//                        textview.setText(String.valueOf(counter));
//                        counter++;
//                    }
//
//                    public void onFinish() {
//                        textview.setText("Finish");
//                    }
//                };
//            }
//        });
    }

    public void StartPause(View v) {
//        Log.d("success", "startwasclicked");
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        AlertDialog dialog = builder.create();
//        dialog.show();
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("my message is thiss");
        builder1.setCancelable(true);
        builder1.show();
    }
}