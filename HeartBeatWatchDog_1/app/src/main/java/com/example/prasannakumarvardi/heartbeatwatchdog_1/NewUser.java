package com.example.prasannakumarvardi.heartbeatwatchdog_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewUser extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText emergencyContact;
    Intent intent;
    String emailNPassword;
    String EmergencyContact;
    Intent intentBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.Password);
        intent=getIntent();
        emailNPassword=intent.getStringExtra("Email+Password");
        String emailVal;
        String passwordVal;
        String pieces[]=emailNPassword.split(":");
        emailVal=pieces[0];
        passwordVal=pieces[1];

        CharSequence emVal=emailVal;
        CharSequence psVal=passwordVal;
       email.setText(emVal, TextView.BufferType.EDITABLE);
        password.setText(psVal, TextView.BufferType.EDITABLE);



        intentBack=new Intent(this,LoginActivity.class);
        startActivity(intentBack);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
