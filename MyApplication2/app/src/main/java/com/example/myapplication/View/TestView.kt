package com.example.myapplication.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils

private val RADIUS = Utils.dp2px(100f)
class TestView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    lateinit var pathMeasure : PathMeasure


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addCircle(width/2f,height/2f, RADIUS,Path.Direction.CCW)
        path.addRect(width/2f- RADIUS,height/2f,width/2f+ RADIUS,height/2f+2* RADIUS,Path.Direction.CCW)
        pathMeasure = PathMeasure(path,false)
        path.fillType = Path.FillType.WINDING
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas.drawPath(path,paint)
    }
}