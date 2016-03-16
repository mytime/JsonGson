package com.example.administrator.jsongson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    public void easyClick(View view) {
        startActivity(new Intent(LaunchActivity.this,JsonArrayActivity.class));

    }

    public void complexClick(View view) {
        startActivity(new Intent(LaunchActivity.this,JsonObjectActivity.class));
    }
}
