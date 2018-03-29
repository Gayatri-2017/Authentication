package com.example.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RegisterActivity extends AppCompatActivity {

    Button mLogin, mRegister;
    EditText mName, mEmail, mPassword, mAge;
    RadioGroup mGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mLogin = (Button)findViewById(R.id.login);
        mRegister = (Button)findViewById(R.id.register);

        mName = (EditText)findViewById(R.id.name);
        mEmail=(EditText)findViewById(R.id.email);
        mPassword=(EditText)findViewById(R.id.password);
        mAge=(EditText)findViewById(R.id.age);

        mGender=(RadioGroup)findViewById(R.id.gender);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void submitForm(){
        int selectedID = mGender.getCheckedRadioButtonId();
        String gender;
        if(selectedID == R.id.female)
            gender = "female";
        else
            gender = "male";
        registerUser(mName.getText().toString(),
                mEmail.getText().toString(),
                mPassword.getText().toString(),
                mAge.getText().toString(),
                gender);
    }
    private void registerUser(final String name, final String email, final String password, final String age, final String gender){
        Intent intent = new Intent(RegisterActivity.this, RegisterSuccessActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("email", email);
        bundle.putString("password", password);
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
