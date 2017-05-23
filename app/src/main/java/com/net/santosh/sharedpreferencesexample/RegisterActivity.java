package com.net.santosh.sharedpreferencesexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefs";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    private TextView name, email, password;
    private String _name, _email, _password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (TextView) findViewById(R.id.reg_name);
        email = (TextView) findViewById(R.id.reg_email);
        password = (TextView) findViewById(R.id.reg_password);
        sharedPreferences = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        progressDialog = new ProgressDialog(getApplicationContext());
    }

    public void onClickRegister(View view) {

        _name = name.getText().toString().trim();
        _email = email.getText().toString().trim();
        _password = password.getText().toString().trim();
        if (_name.length() == 0) {
            name.setError("Please Enter Name");
            name.requestFocus();

        } else if (_email.length() == 0) {
            email.setError("Please Enter Email");
            email.requestFocus();

        } else if (!_email.matches(emailPattern)) {
            email.setError("Please Enter Correct Email");
            email.requestFocus();

        } else if (_password.length() == 0) {
            password.setError("Please Enter password");
            password.requestFocus();

        } else {

            editor.putString("name", _name);
            editor.putString("email", _email);
            editor.putString("password", _password);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Register Successfull", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), sharedPreferences.getString("email", null), Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

    }

    public void onclickLogin(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
