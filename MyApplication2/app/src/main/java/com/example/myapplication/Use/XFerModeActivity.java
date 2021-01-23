package com.example.myapplication.Use;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.myapplication.R;
import com.example.myapplication.View.XFermodeTView;

import static android.graphics.PorterDuff.Mode.ADD;
import static android.graphics.PorterDuff.Mode.CLEAR;
import static android.graphics.PorterDuff.Mode.DARKEN;
import static android.graphics.PorterDuff.Mode.DST;
import static android.graphics.PorterDuff.Mode.DST_ATOP;
import static android.graphics.PorterDuff.Mode.DST_IN;
import static android.graphics.PorterDuff.Mode.DST_OUT;
import static android.graphics.PorterDuff.Mode.DST_OVER;
import static android.graphics.PorterDuff.Mode.LIGHTEN;
import static android.graphics.PorterDuff.Mode.MULTIPLY;
import static android.graphics.PorterDuff.Mode.OVERLAY;
import static android.graphics.PorterDuff.Mode.SCREEN;
import static android.graphics.PorterDuff.Mode.SRC;
import static android.graphics.PorterDuff.Mode.SRC_ATOP;
import static android.graphics.PorterDuff.Mode.SRC_IN;
import static android.graphics.PorterDuff.Mode.SRC_OUT;
import static android.graphics.PorterDuff.Mode.SRC_OVER;
import static android.graphics.PorterDuff.Mode.XOR;
public class XFerModeActivity extends AppCompatActivity {

    private XFermodeTView xFermodeTView;
    private AppCompatSpinner spinner;

    PorterDuff.Mode[] mIntDatas = new PorterDuff.Mode[]{CLEAR,SRC,DST,SRC_OVER,DST_OVER,
            SRC_IN,DST_IN,SRC_OUT,DST_OUT,SRC_ATOP,DST_ATOP,XOR,DARKEN,LIGHTEN,MULTIPLY,
            SCREEN,ADD,OVERLAY};

    String[] mDatas = new String[]{"CLEAR","SRC","DST","SRC_OVER",
    "DST_OVER","SRC_IN","DST_IN","SRC_OUT","DST_OUT","SRC_ATOP","DST_ATOP","XOR",
            "DARKEN","LIGHTEN","MULTIPLY","SCREEN","ADD","OVERLAY"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_fer_mode);
        xFermodeTView = findViewById(R.id.xFermodeTView);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,mDatas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xFermodeTView.setType(mIntDatas[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}