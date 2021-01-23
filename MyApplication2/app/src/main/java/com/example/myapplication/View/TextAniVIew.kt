package com.example.myapplication.View

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.Utils

val provinces = listOf("阿拉善盟", "鞍山", "安庆", "安阳", "阿坝", "安顺", "阿里", "安康", "阿克苏", "阿勒泰" ,"澳门" ,"安吉" ,"安丘" ,"安岳" ,"安平" ,"安溪" ,"安宁" ,"安化" ,"阿拉尔" ,"安福" ,"阿勒泰市", "阿图什市" ,"安州市" ,"阿荣旗" ,"安陆市")

class TextAniVIew(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val bounds =  Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        textAlign = Paint.Align.CENTER
        textSize = Utils.dp2px(30f)
        strokeWidth = Utils.dp2px(20f)
        strokeCap = Paint.Cap.ROUND
        isFakeBoldText = true
    }

    init {
        setLayerType(LAYER_TYPE_HARDWARE,null)//硬件绘制，GPU绘制离屏缓冲 --- 动画时开启离屏缓冲
        setLayerType(LAYER_TYPE_SOFTWARE,null)//关闭硬件加速--没有提供关闭硬件加速的开关，但是硬件加速关了还可以用软件绘制
        setLayerType(LAYER_TYPE_NONE,null)//关闭离屏缓冲】

        //可在属性动画中使用   "withLayer"  执行时开启，不执行时关闭  动画时可进行离屏缓冲

    }

    var province = "阿拉善盟"
    set(value) {
        field = value
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.getTextBounds(province,0,province.length,bounds)
        canvas.drawText(province,width/2f,height/2f-(bounds.top+bounds.bottom)/2f,paint)
    }
}

class ProvinceEvaluator : TypeEvaluator<String>{
    override fun evaluate(fraction: Float, startValue: String?, endValue: String?): String {

        val startIndex = provinces.indexOf(startValue)
        val endIndex = provinces.indexOf(endValue)
        val currentIndex = startIndex + ((endIndex - startIndex) * fraction).toInt()
        return provinces[currentIndex]
    }

}