package com.example.bebe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
  Button calender ;
  Button live ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        calender = findViewById(R.id.sch);
        live = findViewById(R.id.livecam);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(SecondActivity.this , Schedule.class);
                        startActivity(intent);
                    }
                });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://2.2.2.1"));
            startActivity(browserIntent);
            }
        });

    }

}