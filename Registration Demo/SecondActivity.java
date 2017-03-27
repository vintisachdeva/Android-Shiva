package com.bmpl.registrationdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String pswrd = intent.getStringExtra("password");

        textView.setText("Name= " +name + " \nEmail= "+ email +" \nPassword= " +pswrd);

    }
}
