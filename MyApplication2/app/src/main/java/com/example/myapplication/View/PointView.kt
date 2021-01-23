package com.example.myapplication.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils

class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        strokeWidth = Utils.dp2px(20f)
        strokeCap = Paint.Cap.ROUND
    }


    var point = PointF(0f,0f)
    set(value) {
        field = value;
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPoint(point.x,point.y,paint)
    }
}