package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView valueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueTextView = findViewById(R.id.valueTextView);
        valueTextView.setText("0"); // initialize the value

        Button inc = findViewById(R.id.incrementButton);
        Button dec = findViewById(R.id.decrementButton);
        Button res = findViewById(R.id.resetButton);

    }

    public void incrementClicked(View view) {
        int value = Integer.parseInt((String) valueTextView.getText());
        valueTextView.setText(Integer.toString(++value));
    }

    public void decrementClicked(View view) {
        int value = Integer.parseInt((String) valueTextView.getText());
        valueTextView.setText(Integer.toString(--value));
    }

    public void resetClicked(View view) {
        valueTextView.setText("0");
    }
}