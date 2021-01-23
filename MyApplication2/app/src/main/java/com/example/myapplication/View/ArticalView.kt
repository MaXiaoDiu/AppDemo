package com.example.myapplication.View

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.Utils

private val IMAGE_SIZE = Utils.dp2px(150f)
private val IMAGE_PADDING = Utils.dp2px(50f)

class ArticalView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = TextPaint()
    private val paintbitmap = Paint(Paint.ANTI_ALIAS_FLAG)
    private val fontMetrics = Paint.FontMetrics()
    init {
        paint.textSize = Utils.dp2px(10f)
    }

    val text = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
            "\n" +
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    private val bitmap = getAvaor(IMAGE_SIZE.toInt())

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.getFontMetrics(fontMetrics)
        //-fontMetrics.top   --- 贴顶了
        //这行
        val measureWidth = floatArrayOf(0f)

        var maxWidth : Float
        var start = 0
        var count : Int
        var verticalOffset = -fontMetrics.top
        while (start<text.length){
            if (verticalOffset+fontMetrics.bottom < IMAGE_PADDING
                    || verticalOffset+fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE){

                maxWidth = width.toFloat()


            }else{

                maxWidth = width.toFloat()- IMAGE_SIZE

            }
            count = paint.breakText(text,start,text.length,true,maxWidth,measureWidth)
            canvas.drawText(text,start,start+count,0f,verticalOffset,paint)
            start+=count
            verticalOffset +=paint.fontSpacing
        }

        canvas.drawBitmap(bitmap,width - IMAGE_SIZE,IMAGE_PADDING,paintbitmap)
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