package com.example.authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterSuccessActivity extends AppCompatActivity {

    private TextView mName, mEmail, mAge, mPassword, mGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        Bundle bundle = getIntent().getExtras();

        mName = (TextView)findViewById(R.id.name);
        mAge = (TextView)findViewById(R.id.age);
        mEmail = (TextView)findViewById(R.id.email);
        mGender = (TextView)findViewById(R.id.gender);
        mPassword = (TextView)findViewById(R.id.password);

        mName.setText(bundle.getCharSequence("name"));
        mAge.setText(bundle.getCharSequence("age"));
        mPassword.setText(bundle.getCharSequence("password"));
        mGender.setText(bundle.getCharSequence("gender"));
        mEmail.setText(bundle.getCharSequence("email"));

    }
}
