package com.example.myapplication.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.Utils

private val BITMAP_SIZE = Utils.dp2px(200f)
private val BITMAP_PADDING = Utils.dp2px(100f)

class CanvasView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvaor(BITMAP_SIZE.toInt())

    private val path = Path().apply {
        addOval(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING+ BITMAP_SIZE, BITMAP_PADDING+ BITMAP_SIZE,Path.Direction.CCW)
    }

    private val camera = Camera()

    var topFlip = 0f
    set(value) {
        field = value
        invalidate()
    }
    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }


    init {
        //旋转效果
        camera.setLocation(0f,0f,-8f * resources.displayMetrics.density)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //clipRect --裁切
        //canvas.clipRect(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING+ BITMAP_SIZE/2f,BITMAP_PADDING+ BITMAP_SIZE/2f)
        //canvas.clipPath(path) --可以切任何图形
        //translate(X,Y)
        //rotate(degree)
        //scale(x,y)
        //skew(x,y)
        //Matrix的几何变换 - preXXX PostXXX   注意步骤！！！
        //<!==============Camera=============!>

        canvas.save()
        //上半部分
        canvas.translate(BITMAP_PADDING+ BITMAP_SIZE/2,BITMAP_PADDING+ BITMAP_SIZE/2)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_SIZE,  -BITMAP_SIZE, BITMAP_SIZE,0f)
        canvas.rotate(flipRotation)
        canvas.translate(-(BITMAP_PADDING+ BITMAP_SIZE/2),-(BITMAP_PADDING+ BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
        canvas.restore()

        //下半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING+ BITMAP_SIZE/2,BITMAP_PADDING+ BITMAP_SIZE/2)
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
        canvas.rotate(flipRotation)
        canvas.translate(-(BITMAP_PADDING+ BITMAP_SIZE/2),-(BITMAP_PADDING+ BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
        canvas.restore()


    }


    fun getAvaor(width:Int): Bitmap {
        val option = BitmapFactory.Options()
        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.icon,option)
        option.inJustDecodeBounds = false
        option.inDensity = option.outWidth
        option.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.icon,option)
    }
}