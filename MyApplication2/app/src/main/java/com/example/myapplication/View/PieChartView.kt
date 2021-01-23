package com.example.myapplication.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils
import java.lang.Math.cos
import kotlin.math.sin

private val RADIUS = Utils.dp2px(100f)
private val ANGLES = floatArrayOf(60f,90f,150f,60f)
private val COLORS = listOf(Color.parseColor("#2E8B57"),Color.parseColor("#FFD700"),
        Color.parseColor("#FF8C00"),Color.parseColor("#00BFFF"))
private val OFFSET_LENGTH = 20f
class PieChartView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init{
        paint.strokeWidth = Utils.dp2px(3f)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画弧
        var startangle = 0f;
        for ((index,angle) in ANGLES.withIndex()){
            if (index==1){
                canvas.save()
                canvas.translate(OFFSET_LENGTH * cos(Math.toRadians(startangle+angle/2f.toDouble())).toFloat(),OFFSET_LENGTH* sin(Math.toRadians(startangle+angle/2f.toDouble())).toFloat())
            }
            paint.color = COLORS[index]
            canvas.drawArc(width/2f- RADIUS,height/2f- RADIUS,width/2f+ RADIUS,height/2f+ RADIUS, startangle, angle,true,paint)
            startangle += angle;

            if (index==1){
                canvas.restore()
            }
        }
    }
}