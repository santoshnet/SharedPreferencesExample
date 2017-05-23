package com.net.santosh.sharedpreferencesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignInClicked(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void onSignUpClicked(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }
}
