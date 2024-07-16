package com.example.bebe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEvent extends AppCompatActivity {
    EditText nom , date , description ;
    Button ajouter ;
    Helper h = new Helper(AddEvent.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nameevent);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        ajouter = findViewById(R.id.val);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                events e = new events(nom.getText().toString(),
                        Double.parseDouble(date.getText().toString()),description.getText().toString());
                h.insertEvent(e);
                Intent i = new Intent(AddEvent.this, Event_Calendar.class );
                startActivity(i);

            }
        });
    }
}