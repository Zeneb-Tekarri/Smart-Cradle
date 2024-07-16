package com.example.bebe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    EditText email , password;
    Button login, inscription;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.welcome);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.btt);
        inscription = findViewById(R.id.btt2);
        DB = new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= email.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this , "all fields required",Toast.LENGTH_LONG);
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if (checkuserpass== true ){
                        Toast.makeText(MainActivity.this , "sign in successfully",Toast.LENGTH_LONG);
                        Intent i = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(MainActivity.this,"LOGIN ou PASSWORD incorrect ",Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("attention");
                alert.setMessage("is it your first time using the app ?");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent j = new Intent(MainActivity.this,InscriptionActivity.class);
                        startActivity(j);
                    }
                });
                alert.setNegativeButton("no",null);
                alert.show();
            }
        });

    }
}