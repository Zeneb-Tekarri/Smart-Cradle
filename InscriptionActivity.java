package com.example.bebe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {
    EditText name , surname,mail,pass,babyname,age;
    Button val ;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        name = findViewById(R.id.edt1);
        surname = findViewById(R.id.edt2);
        mail = findViewById(R.id.edt3);
        pass = findViewById(R.id.edt4);
        babyname = findViewById(R.id.edt5);
        age = findViewById(R.id.edt6);
        val = findViewById(R.id.btt3);
        DB= new DBHelper(this);
        val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= mail.getText().toString();
                String password = pass.getText().toString();
                String nom= name.getText().toString();
                String prenom= surname.getText().toString();
                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(password) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(prenom))
                    Toast.makeText(InscriptionActivity.this, "fields required", Toast.LENGTH_LONG).show();
                else
                { Boolean checkuser =  DB.checkusername(user);
                    if (checkuser== false){
                        Boolean insert= DB.insertData(user,password);
                        if (insert == true){
                            AlertDialog.Builder alert= new AlertDialog.Builder(InscriptionActivity.this);
                            alert.setTitle("verification");
                            alert.setMessage("are you sure of the information ? ");
                            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent j = new Intent(InscriptionActivity.this,MainActivity.class);
                                    startActivity(j);
                                }
                            });
                            alert.setNegativeButton("no",null);
                            alert.show();
                        }else {
                            Toast.makeText(InscriptionActivity.this, "Registred Failed" , Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(InscriptionActivity.this, "User Already Exists", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}