package com.example.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast t = Toast.makeText(getApplicationContext(), "Activity Created",
                Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast t = Toast.makeText(getApplicationContext(), "Activity Resumed",
                Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast t = Toast.makeText(getApplicationContext(), "Activity Started",
                Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast t = Toast.makeText(getApplicationContext(), "Activity Paused",
                Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast t = Toast.makeText(getApplicationContext(), "Activity Stopped",
                Toast.LENGTH_SHORT);
        t.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast t = Toast.makeText(getApplicationContext(), "Activity Destroyed",
                Toast.LENGTH_SHORT);
        t.show();
    }
}