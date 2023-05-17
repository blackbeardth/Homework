package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    private RadioGroup rgCourses;
    private HashMap<String, String> coursesMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCourses();
    }
    private void initCourses(){
        rgCourses=(RadioGroup)findViewById(R.id.rgCourses);
        if (coursesMap==null){
            coursesMap=new HashMap<>();
            coursesMap.put("BSc(H) Computer Science","Deptt of Computer Sc - Dr.V.S.Dixit");
            coursesMap.put("BCom(H)","Deptt of Commerce - Dr.Manika Jain");
            coursesMap.put("BA(H) Sociology"," Deptt of Economics - Dr. Apra Sinha");
            for (String course : coursesMap.keySet()){
                RadioButton rButton=new RadioButton(MainActivity.this);
                rButton.setText(course);
                rgCourses.addView(rButton);
            }
            rgCourses.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int checkedRadioButtonId=rgCourses.getCheckedRadioButtonId();
                    RadioButton rButton=(RadioButton) findViewById(checkedRadioButtonId);
                    Snackbar.make(rgCourses,coursesMap.get(rButton.getText()),Snackbar.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}