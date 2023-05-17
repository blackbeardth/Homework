package com.example.practical3;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new HashMap<String, String>();
    }

    public void registerButtonPressed(View view) {
        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        TextView message = findViewById(R.id.messageTextView);
        Button register = findViewById(R.id.registerButton);

        // Get a reference to the InputMethodManager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // Hide the keyboard
        imm.hideSoftInputFromWindow(register.getWindowToken(), 0);

        // if username or password is empty
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            message.setTextColor(Color.RED);
            message.setText("Please fill all text fields...");
            return;
        }
        // if username is not available
        if (users.containsKey(username.getText().toString())) {
            message.setTextColor(Color.RED);
            message.setText("Username is already taken...");
            return;
        }

        // create new user
        users.put(username.getText().toString(), password.getText().toString());
        message.setTextColor(Color.GREEN);
        message.setText("Registration successful!");

        username.setText("");
        password.setText("");

    }

    public void loginButtonPressed(View view) {
        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        TextView message = findViewById(R.id.messageTextView);
        Button login = findViewById(R.id.loginButton);

        // Get a reference to the InputMethodManager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // Hide the keyboard
        imm.hideSoftInputFromWindow(login.getWindowToken(), 0);

        // if username or password is empty
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            message.setTextColor(Color.RED);
            message.setText("Please fill all text fields...");
            return;
        }

        // if username is incorrect
        if (!users.containsKey(username.getText().toString())) {
            message.setTextColor(Color.RED);
            message.setText("No such user exists...");
            return;
        }

        // if password is incorrect
        if (!users.get(username.getText().toString()).equals(password.getText().toString())) {
            message.setTextColor(Color.RED);
            message.setText("Incorrect password...");
            return;
        }

        // if username and password are correct
        message.setTextColor(Color.GREEN);
        message.setText("Login Successful!");

        username.setText("");
        password.setText("");
    }
}