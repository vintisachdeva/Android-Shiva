package com.bmpl.registrationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final int reqCode = 10;

    EditText nameEditText, emailEditText, passwordEditText;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize()
    {
        nameEditText = (EditText)findViewById(R.id.userNameEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        signUp = (Button)findViewById(R.id.signUpButton);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        //Source--      Current activity name
        //Destination-- Activity want to start
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        nameEditText.setText("");
        startActivityForResult(intent, reqCode);
        //startActivity(intent);//will start the new mentioned activity

        //Toast.makeText(this, "Name: "+nameEditText.getText()+" Email: "+emailEditText.getText()+ " Password: "+passwordEditText.getText(), Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==reqCode){
            if(resultCode==RESULT_OK)
            {
                nameEditText.setText(data.getStringExtra("name"));
            }
            else if(resultCode==RESULT_CANCELED){

            }
        }

    }
}
