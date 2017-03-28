package com.bmpl.registrationdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    String name, email, pswrd;
    TextView textView;
    Button yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initialize();

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        pswrd = intent.getStringExtra("password");

        textView.setText("Name= " +name + " \nEmail= "+ email +" \nPassword= " +pswrd);
    }

    void initialize(){
        yesButton = (Button)findViewById(R.id.yesButton);
        noButton = (Button)findViewById(R.id.noButton);
        textView = (TextView)findViewById(R.id.textView);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId())
        {
            case R.id.yesButton:
                intent.putExtra("name", name);
                setResult(RESULT_OK, intent);
                finish();//current activity--> finish
                break;
            case R.id.noButton:
                setResult(RESULT_CANCELED);
                finish();//current activity--> finish
                break;
        }
    }
}
