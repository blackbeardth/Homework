package com.example.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.mySpinner);
        imageView = findViewById(R.id.myImageView);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().equals("Image1")) {
                    imageView.setImageResource(R.drawable.image1);
                } else if (spinner.getSelectedItem().equals("Image2")) {
                    imageView.setImageResource(R.drawable.image2);
                } else if (spinner.getSelectedItem().equals("Image3")) {
                    imageView.setImageResource(R.drawable.image3);
                } else if (spinner.getSelectedItem().equals("Image4")) {
                    imageView.setImageResource(R.drawable.image4);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                imageView.setImageResource(R.drawable.image4);
            }
        });
    }
}