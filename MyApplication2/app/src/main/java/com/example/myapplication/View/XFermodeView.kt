package com.example.myapplication.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.Utils

private val IMAGEWIDTH = Utils.dp2px(200f).toInt()
private val IMAGEPADDING = Utils.dp2px(20f)
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
class XFermodeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(IMAGEPADDING,IMAGEPADDING, IMAGEPADDING+ IMAGEWIDTH, IMAGEPADDING+ IMAGEWIDTH)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = canvas.saveLayer(bounds,null)
        canvas.drawOval(IMAGEPADDING,IMAGEPADDING, IMAGEPADDING+ IMAGEWIDTH, IMAGEPADDING+ IMAGEWIDTH,paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(getAvaor(IMAGEWIDTH),IMAGEPADDING,IMAGEPADDING, paint)
        canvas.restoreToCount(count)
    }

    fun getAvaor(width:Int):Bitmap{
        val option = BitmapFactory.Options()
        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.icon,option)
        option.inJustDecodeBounds = false
        option.inDensity = option.outWidth
        option.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,R.mipmap.icon,option)
    }

}