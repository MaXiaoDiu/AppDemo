package com.example.myapplication.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils
import kotlin.math.cos
import kotlin.math.sin

private val RADIUSDASH = Utils.dp2px(100f)
private const val OPENANGLE = 120f
private val DASH_WIDTH = Utils.dp2px(2f)
private val DASH_LENGTH = Utils.dp2px(5f)
private val LENGTH = RADIUSDASH-Utils.dp2px(10f)
class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dash = Path()
    private val path = Path()
    private lateinit var pathEffect: PathEffect

    init{
        paint.strokeWidth = Utils.dp2px(3f)
        paint.style = Paint.Style.STROKE
        dash.addRect(0f,0f,DASH_WIDTH, DASH_LENGTH,Path.Direction.CCW)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(width/2f- RADIUSDASH,height/2f- RADIUSDASH,width/2f+ RADIUSDASH,height/2f+ RADIUSDASH, 90+OPENANGLE/2,360 - OPENANGLE)
        val pathMeasure = PathMeasure(path,false)
        pathEffect = PathDashPathEffect(dash,(pathMeasure.length- DASH_WIDTH)/20f,0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画弧
        canvas.drawPath(path,paint)
        //advance 偏移 phase 间隔
        //寻找总长度
        paint.pathEffect = pathEffect
        canvas.drawPath(path,paint)
        paint.pathEffect = null
        //有一个角度的余弦，一个正弦--正弦余弦的使用
        val stopx = width/2f+LENGTH * cos(markToRadius(5)).toFloat()
        val stopy = height/2f+LENGTH * sin(markToRadius(5)).toFloat()
        canvas.drawLine(width/2f,height/2f,stopx,stopy,paint)
    }

    fun markToRadius(mark:Int)=Math.toRadians((90+ OPENANGLE/2f+(360- OPENANGLE)/20f * mark).toDouble())

}