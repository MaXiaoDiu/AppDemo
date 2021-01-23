package com.example.myapplication.Use;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.Utils;
import com.example.myapplication.View.CircleView;
import com.example.myapplication.View.PointView;
import com.example.myapplication.View.ProvinceEvaluator;
import com.example.myapplication.View.TextAniVIew;

public class AnimatorMainActivity extends AppCompatActivity {

    private ImageView imageView,imageView2;
    private CircleView circleView;
    private ObjectAnimator animator;

    private Keyframe keyframe1,keyframe2,keyframe3,keyframe4;
    private PropertyValuesHolder propertyValuesHolder;
    private ObjectAnimator objectAnimator,objectAnimator2,objectAnimatorpointview,objectAnimatortext;
    private PointView pointview;
    private TextAniVIew textantiview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_main);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        circleView = findViewById(R.id.circleView);
//        imageView.animate() //.scaleX(2f) .scaleY(2f)
//                .translationX(Utils.dp2px(100f))
//                .translationY(Utils.dp2px(100f))
//                .setStartDelay(300);
//        animator = ObjectAnimator.ofFloat(circleView,"radius",Utils.dp2px(100f));
//        animator.setDuration(1000);
//        animator.start();
        pointview = findViewById(R.id.pointview);
        textantiview = findViewById(R.id.textantiview);
        //animaset动画集
        float length = Utils.dp2px(200f);
        keyframe1 = Keyframe.ofFloat(0f,0f);
        keyframe2 = Keyframe.ofFloat(0.2f,0.4f*length);
        keyframe3 = Keyframe.ofFloat(0.8f,0.6f*length);
        keyframe4 = Keyframe.ofFloat(1f,1f*length);
        propertyValuesHolder = PropertyValuesHolder.ofKeyframe("translationX",keyframe1,keyframe2,keyframe3,keyframe4);
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView,propertyValuesHolder);
        objectAnimator.setDuration(2000);
        objectAnimator.start();

        animator = ObjectAnimator.ofFloat(circleView,"radius",Utils.dp2px(100f));
        animator.setDuration(1000);
        animator.start();

        objectAnimator2 = ObjectAnimator.ofFloat(imageView2,"translationX",Utils.dp2px(100f));
        objectAnimator2.setInterpolator(new AccelerateInterpolator());
        objectAnimator2.setDuration(2000);
        objectAnimator2.start();

        objectAnimatorpointview = ObjectAnimator.ofObject(pointview,"point",new PointFEvaluator(),new PointF(Utils.dp2px(100f),Utils.dp2px(200f)));
        objectAnimatorpointview.setDuration(2000);
        objectAnimatorpointview.start();



        objectAnimatortext = ObjectAnimator.ofObject(textantiview,"province",new ProvinceEvaluator(),"安陆市");
        objectAnimatortext.setDuration(5000);
        objectAnimatortext.start();

    }

    class PointFEvaluator implements TypeEvaluator<PointF> {

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {

            float startx = startValue.x;
            float endx = endValue.x;
            float currentx = startx + (endx-startx) * fraction;

            float starty = startValue.y;
            float endy = endValue.y;
            float currenty = starty + (endy-starty) * fraction;

            return new PointF(currentx,currenty);
        }
    }
}