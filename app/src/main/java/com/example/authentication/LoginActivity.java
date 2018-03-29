package com.example.authentication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin, mRegister;
    private EditText mEmail, mPassword;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText)findViewById(R.id.email);
        mLogin = (Button)findViewById(R.id.login);
        mPassword = (EditText)findViewById(R.id.password);
        mRegister=(Button)findViewById(R.id.register);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEmail.getText().toString().equals("admin@gmail.com") && mPassword.getText().toString().equals("pass")){
                    Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    TextView t1;
                    t1 = (TextView)findViewById(R.id.textView1);
                    t1.setVisibility(View.VISIBLE);
                    t1. setTextColor(Color.BLACK);
                    t1.setBackgroundColor(Color.RED);
                    counter--;
                    t1.setText("No. of attempts left " + Integer.toString(counter));
                    if(counter==0){
                        t1.setText("You have exceeded max attempts for the day!");
                        mLogin.setEnabled(false);
                    }
                }

            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
