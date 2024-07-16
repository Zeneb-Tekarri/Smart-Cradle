package com.example.bebe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    EditText nom , date , description ;
    Button modifier , supprimer ;
    String id ;
    Helper h = new Helper(DetailActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nom = findViewById(R.id.name2);
        date = findViewById(R.id.date3);
        description = findViewById(R.id.description3);
        modifier = findViewById(R.id.mod);
        supprimer = findViewById(R.id.sup);
        id = getIntent().getStringExtra("id");
        events e = h.getOneEvent(Integer.parseInt(id));
        nom.setText(e.getTitle());
        date.setText(String.valueOf(e.getDate()));
        description.setText(e.getDescription());
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                events ev = new events(Integer.parseInt(id), nom.getText().toString(),
                        Double.parseDouble(date.getText().toString()), description.getText().toString());
                h.updateEvent(ev);
                Intent i = new Intent(DetailActivity.this, Event_Calendar.class);
                startActivity(i);
            }
        });
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h.deleteEvent(Integer.parseInt(id));
                Intent i = new Intent(DetailActivity.this, Event_Calendar.class);
                startActivity(i);
            }
        });

    }
}