package com.example.bebe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.HashMap;

public class Event_Calendar extends AppCompatActivity {
    ListView lst ;
    Helper h = new Helper(Event_Calendar.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_calendar);
        lst = findViewById(R.id.liste);
        Cursor c = h.getAllEvent();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(Event_Calendar.this,R.layout.item,c,
                new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2),c.getColumnName(3)},
                new int[]{R.id.id,R.id.name,R.id.date2,R.id.description2},1);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t = view.findViewById(R.id.id);
                Intent x = new Intent(Event_Calendar.this,DetailActivity.class);
                x.putExtra("id",t.getText().toString());
                startActivity(x);
            }
        });
    }
}