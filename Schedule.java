package com.example.bebe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;
    Button event, addEvent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        calendar = findViewById(R.id.calendar);
        date_view = findViewById(R.id.date_view);
        event = findViewById(R.id.event);
        addEvent = findViewById(R.id.addevent);
        calendar
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                // set this date in TextView for Display
                                date_view.setText(Date);
                            }
                        });
    event.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent j = new Intent(Schedule.this,Event_Calendar.class);
            startActivity(j);
        }
    });
    addEvent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent(Schedule.this, AddEvent.class);
            startActivity(addIntent);
        }
    });
    }
}