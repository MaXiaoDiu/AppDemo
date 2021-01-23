package com.example.myapplication.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils

private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
private val RING_WIDTH = Utils.dp2px(20f)
private val RADIUS = Utils.dp2px(150f)
class TestTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    private val bounds =  Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = Utils.dp2px(80f)
        textAlign= Paint.Align.CENTER
        isFakeBoldText = true
    }

    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制环
        paint.style = Paint.Style.STROKE
        paint.color = CIRCLE_COLOR
        paint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width/2f,height/2f, RADIUS,paint)
        //绘制进度条
        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(width/2f- RADIUS,height/2f- RADIUS
        ,width/2f+ RADIUS,height/2f+ RADIUS,-90f,225f,false,paint)
        paint.style = Paint.Style.FILL
        //绘制文字
        paint.getTextBounds("52",0,"52".length,bounds)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText("52",width/2f,height/2f-(fontMetrics.ascent+fontMetrics.descent)/2f,paint)


        //绘制顶边
        paint.textAlign = Paint.Align.LEFT
        paint.getFontMetrics(fontMetrics)
        paint.getTextBounds("52",0,"52".length,bounds)
        canvas.drawText("abab",-bounds.left.toFloat(),-bounds.top.toFloat(),paint)

    }
}