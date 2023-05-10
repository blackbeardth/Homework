package com.example.practical15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, age, mobile;
    Button insert, update, delete, view;
    DBhelper db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        mobile = findViewById(R.id.mobile);
        insert = findViewById(R.id.buttonInsert);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);
        view = findViewById(R.id.buttonView);
        db = new DBhelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String ageTXT = age.getText().toString();
                String mobileTXT = mobile.getText().toString();
                Boolean checkinsertdata = db.insertuserdata(nameTXT, ageTXT, mobileTXT);
                if (checkinsertdata == true) {
                    Toast.makeText(MainActivity.this, "New Record Inserted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Record  Not Inserted",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String ageTXT = age.getText().toString();
                String mobileTXT = mobile.getText().toString();
                Boolean checkupdatedata = db.updateuserdata(nameTXT, ageTXT, mobileTXT);
                if (checkupdatedata == true)
                    Toast.makeText(MainActivity.this, "Record Updated",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Record  Not Updated",
                            Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkdeletedata = db.deletedata(nameTXT);
                if (checkdeletedata == true)
                    Toast.makeText(MainActivity.this, "Record Deleted",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Record  Not Deleted",
                            Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cursor res = db.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Record Not Exists",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("sid:" + res.getString(0) + "\n");
                    buffer.append("name:" + res.getString(1) + "\n");
                    buffer.append("age:" + res.getString(2) + "\n");
                    buffer.append("mobile:" + res.getString(3) + "\n");
                    buffer.append("----------------------\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Data Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
