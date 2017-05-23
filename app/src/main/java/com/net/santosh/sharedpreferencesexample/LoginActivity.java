package com.net.santosh.sharedpreferencesexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.net.santosh.sharedpreferencesexample.RegisterActivity.MY_PREFS_NAME;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    private TextView email, password;
    private String _email, _password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (TextView) findViewById(R.id.login_email);
        password = (TextView) findViewById(R.id.login_password);
        sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        _email = sharedPreferences.getString("email", null);
        _password = sharedPreferences.getString("password", null);
        editor = sharedPreferences.edit();
      /*  email.setText(_email);
        password.setText(_password);*/

    }

    public void onclickTextRegister(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void onClickBtnLogin(View view) {
        String email_id = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();

        if (email_id.length() == 0) {
            email.setError("Please Enter Email");
            email.requestFocus();
            progressDialog.dismiss();
        } else if (!email_id.matches(emailPattern)) {
            email.setError("Please Enter Correct Email");
            email.requestFocus();

        } else if (password1.length() == 0) {
            password.setError("Please Enter password");
            password.requestFocus();

        } else if (!email_id.equalsIgnoreCase(_email) && !password1.equalsIgnoreCase(_password)) {
            Toast.makeText(getApplicationContext(), "Pleasse check Email and Password", Toast.LENGTH_LONG).show();
        } else {

            editor.putString("email1", email_id);
            editor.putString("password1", password1);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), DetailsActivity.class));
        }
    }
}
