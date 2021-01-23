package com.example.myapplication.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils


class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()
    var radius = Utils.dp2px(50f)

    set(value) {
        field = value
        invalidate()
    }

    init {
        paint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width/2f,height/2f, radius,paint)
    }
}