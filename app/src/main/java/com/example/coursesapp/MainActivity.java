package com.example.coursesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] Departments = {"Energy and Renewable Energy Engineering Program","Computer Engineering and Software Systems Program","Building Engineering Program","Communication Systems Engineering Program","Materials Engineering Program"
            ,"Manufacturing Engineering Program", "Landscape Architecture Program","Mechatronics Engineering and Automation Program","Environmental Architecture and Urbanism Program"};
    ListView List= null;
    ImageView Logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logo = (ImageView) findViewById(R.id.Logo);
        List = (ListView) findViewById(R.id.Departments);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.layout_listview,Departments);
        List.setAdapter(adapter);
        List.setClickable(true);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = List.getItemAtPosition(position);
                String dep = o.toString();
                Intent first = new Intent(getApplicationContext(), offeredCourses.class);
                first.putExtra("Department", dep);
                startActivity(first);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OverViewActivity.class);
                startActivity(intent);
            }

        });

    }

}
