package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Use.AnimatorMainActivity;
import com.example.myapplication.Use.ArticalActivity;
import com.example.myapplication.Use.CanvasActivity;
import com.example.myapplication.Use.DashBoardActivity;
import com.example.myapplication.Use.PathActivity;
import com.example.myapplication.Use.PieChartActivity;
import com.example.myapplication.Use.TextViewActivity;
import com.example.myapplication.Use.XFerModeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_Path,btn_dashboard,btn_piechart,btn_fermode,
    btn_testview,btn_mulTextView,btn_canvas,btn_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_Path = findViewById(R.id.btn_Path);
        btn_Path.setOnClickListener(this);
        btn_dashboard = findViewById(R.id.btn_dashboard);
        btn_dashboard.setOnClickListener(this);
        btn_piechart = findViewById(R.id.btn_piechart);
        btn_piechart.setOnClickListener(this);
        btn_fermode = findViewById(R.id.btn_fermode);
        btn_fermode.setOnClickListener(this);
        btn_testview = findViewById(R.id.btn_testview);
        btn_testview.setOnClickListener(this);
        btn_mulTextView = findViewById(R.id.btn_mulTextView);
        btn_mulTextView.setOnClickListener(this);
        btn_canvas = findViewById(R.id.btn_canvas);
        btn_canvas.setOnClickListener(this);
        btn_anim = findViewById(R.id.btn_anim);
        btn_anim.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_Path:
                startActivity(new Intent(MainActivity.this, PathActivity.class));
                break;
            case R.id.btn_dashboard:
                startActivity(new Intent(MainActivity.this, DashBoardActivity.class));
                break;
            case R.id.btn_piechart:
                startActivity(new Intent(MainActivity.this, PieChartActivity.class));
                break;
            case R.id.btn_fermode:
                startActivity(new Intent(MainActivity.this, XFerModeActivity.class));
                break;
            case R.id.btn_testview:
                startActivity(new Intent(MainActivity.this, TextViewActivity.class));
                break;
            case R.id.btn_mulTextView:
                startActivity(new Intent(MainActivity.this, ArticalActivity.class));
                break;
            case R.id.btn_canvas:
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
                break;
            case R.id.btn_anim:
                startActivity(new Intent(MainActivity.this, AnimatorMainActivity.class));
                break;
        }
    }
}