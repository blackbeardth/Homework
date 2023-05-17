package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveNameActivity extends AppCompatActivity {

    TextView tv;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_name);
        tv=findViewById(R.id.textView);
        st=getIntent().getExtras().getString("Value");
        tv.setText(st);
    }
}

