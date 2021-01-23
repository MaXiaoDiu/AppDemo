package com.example.myapplication.Use;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.View.CanvasView;

public class CanvasActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ObjectAnimator topFlipAnimator,bottomFlipAnimator,flipRotationAnimator;
    private CanvasView canvasView;
    private RadioGroup radioGroup;
    private boolean isTop = false;
    private boolean isBottom = false;
    private boolean isRotation = false;

    private AnimatorSet animatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        canvasView = findViewById(R.id.canvasView);
        topFlipAnimator = new ObjectAnimator();
        animatorSet = new AnimatorSet();
        topFlipAnimator = ObjectAnimator.ofFloat(canvasView,"topFlip",60f);
        bottomFlipAnimator = ObjectAnimator.ofFloat(canvasView,"bottomFlip",60f);
        flipRotationAnimator = ObjectAnimator.ofFloat(canvasView,"flipRotation",60f);

        //还有一个PropertyValueHolder 可以替代AnimatorSet


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){

            case R.id.radio_top:
                if (!isTop){
                    topFlipAnimator = ObjectAnimator.ofFloat(canvasView,"topFlip",60f);
                    topFlipAnimator.setDuration(1000);
                    topFlipAnimator.start();
                }else {
                    topFlipAnimator = ObjectAnimator.ofFloat(canvasView,"topFlip",0f);
                    topFlipAnimator.setDuration(1000);
                    topFlipAnimator.start();
                }
                isTop = !isTop;
                break;
            case R.id.radio_bottom:
                if (!isBottom){
                    bottomFlipAnimator = ObjectAnimator.ofFloat(canvasView,"bottomFlip",60f);
                    bottomFlipAnimator.setDuration(1000);
                    bottomFlipAnimator.start();
                }else {
                    bottomFlipAnimator = ObjectAnimator.ofFloat(canvasView,"bottomFlip",0f);
                    bottomFlipAnimator.setDuration(1000);
                    bottomFlipAnimator.start();
                }
                isBottom = !isBottom;
                break;
            case R.id.radio_skew:
                if (!isRotation){
                    flipRotationAnimator = ObjectAnimator.ofFloat(canvasView,"flipRotation",60f);
                    flipRotationAnimator.setDuration(1000);
                    flipRotationAnimator.start();
                }else {
                    flipRotationAnimator = ObjectAnimator.ofFloat(canvasView,"flipRotation",0f);
                    flipRotationAnimator.setDuration(1000);
                    flipRotationAnimator.start();
                }
                isRotation = !isRotation;
                break;
            case R.id.radio_set:
                animatorSet.playSequentially(bottomFlipAnimator,topFlipAnimator,flipRotationAnimator);
                animatorSet.setDuration(500);
                animatorSet.start();
                break;
        }
    }
}