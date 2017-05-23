package com.net.santosh.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.net.santosh.sharedpreferencesexample.RegisterActivity.MY_PREFS_NAME;

public class DetailsActivity extends AppCompatActivity {
    TextView name, email;
    String _name, _email, _password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = (TextView) findViewById(R.id.det_name);
        email = (TextView) findViewById(R.id.det_email);
        sharedPreferences = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        _name = sharedPreferences.getString("name", null);
        _email = sharedPreferences.getString("email1", null);
        _password = sharedPreferences.getString("password1", null);

        name.setText(_name);
        email.setText(_email);

    }

    public void onLogoutClicked(View view) {
        editor = sharedPreferences.edit();
        editor.remove("email1");
        editor.remove("password1");
        editor.commit();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
