package com.example.practical7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layoutSuperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutSuperParent = findViewById(R.id.layoutSuperParent);
    }

    public void redButtonPressed(View view) {
        layoutSuperParent.setBackgroundColor(Color.RED);
    }
    public void greenButtonPressed(View view) {
        layoutSuperParent.setBackgroundColor(Color.GREEN);
    }
    public void blueButtonPressed(View view) {
        layoutSuperParent.setBackgroundColor(Color.BLUE);
    }
}