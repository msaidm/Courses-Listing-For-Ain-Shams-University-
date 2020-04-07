package com.example.coursesapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class offeredCourses extends AppCompatActivity {
    ListView List2= null;
    InputStream inputReader;
    TextView Department ;
    ImageView Logo;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_courses);
        List2 = (ListView) findViewById(R.id.offeredCoursesList);
        Department = (TextView) findViewById(R.id.departmentName);
        Logo = (ImageView) findViewById(R.id.Logo);
        Intent intent = getIntent();
        String dep = intent.getStringExtra("Department");
        Department.setText(dep);

        if(dep.equals("Building Engineering Program"))
        {fileName="building";}
        else if(dep.equals("Computer Engineering and Software Systems Program"))
        {fileName = "computer";}
        else if(dep.equals("Landscape Architecture Program"))
        {fileName = "landscape";}
        else if(dep.equals("Environmental Architecture and Urbanism Program"))
        { fileName = "environmental";}
        else if(dep.equals("Mechatronics Engineering and Automation Program"))
        {  fileName = "mechatronics";}
        else if(dep.equals("Communication Systems Engineering Program"))
        {fileName="communication";}
        else if(dep.equals("Materials Engineering Program"))
        {fileName="materials";}
        else if(dep.equals("Manufacturing Engineering Program"))
        {fileName = "manufacturing";}
        else if(dep.equals("Energy and Renewable Energy Engineering Program"))
        {fileName = "energy";}

        if(fileName=="building")
            inputReader = this.getResources().openRawResource(R.raw.building);
        else if(fileName=="computer")
            inputReader = this.getResources().openRawResource(R.raw.cess);
        else if(fileName=="landscape")
            inputReader = this.getResources().openRawResource(R.raw.landscape);
        else if(fileName=="environmental")
            inputReader = this.getResources().openRawResource(R.raw.environmental);
        else if(fileName=="energy")
            inputReader = this.getResources().openRawResource(R.raw.energy);
        else if(fileName=="manufacturing")
            inputReader = this.getResources().openRawResource(R.raw.manufacturing);
        else if(fileName=="materials")
            inputReader = this.getResources().openRawResource(R.raw.materials);
        else if(fileName=="communication")
            inputReader = this.getResources().openRawResource(R.raw.communication);
        else if(fileName=="mechatronics")
            inputReader = this.getResources().openRawResource(R.raw.mechatronics);
        try {
            InputStreamReader isr = new InputStreamReader(inputReader);
            BufferedReader bufferReader = new BufferedReader(isr);
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                lines.add(line);
            }
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.layout_listview2,lines);
            List2.setAdapter(adapter2);
        }
        catch (java.io.IOException e){
        }
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OverViewActivity.class);
                startActivity(intent);
            }

        });

    }

}
