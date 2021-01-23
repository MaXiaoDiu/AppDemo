package com.example.myapplication.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils
private var XFERMODE = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
class XFermodeTView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    fun setType(type : PorterDuff.Mode){
        XFERMODE = PorterDuffXfermode(type)
        invalidate()
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(Utils.dp2px(150f),Utils.dp2px(50f), Utils.dp2px(300f), Utils.dp2px(200f))

    //用drawbitmap
    private val circleBitmap = Bitmap.createBitmap(Utils.dp2px(150f).toInt(),Utils.dp2px(150f).toInt(),Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(Utils.dp2px(150f).toInt(),Utils.dp2px(150f).toInt(),Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(Utils.dp2px(50f),Utils.dp2px(0f), Utils.dp2px(150f), Utils.dp2px(100f),paint)
        paint.color = Color.parseColor("#2196F3")
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(Utils.dp2px(0f),Utils.dp2px(50f), Utils.dp2px(100f), Utils.dp2px(150f),paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds,null)

        canvas.drawBitmap(circleBitmap,Utils.dp2px(150f),Utils.dp2px(50f),paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap,Utils.dp2px(150f),Utils.dp2px(50f),paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}