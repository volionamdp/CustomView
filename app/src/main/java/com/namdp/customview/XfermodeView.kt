package com.namdp.customview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class XfermodeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        textSize = 50f
    }
    private val paintXfermode = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }
//    private val sizeWidth = 2000
//    private val sizeHeight = 1000
    private val rectHalfSize = 300f
    private val circleRadius1 = 400f
    private val circleRadius2 = 200f
    private val rectF = RectF(0f,0f,100f,100f)
    private val listXfermode:MutableList<PorterDuff.Mode> = mutableListOf(
       (PorterDuff.Mode.CLEAR),

       (PorterDuff.Mode.SRC),
       (PorterDuff.Mode.SRC_IN),
       (PorterDuff.Mode.SRC_OUT),
       (PorterDuff.Mode.SRC_OVER),
       (PorterDuff.Mode.SRC_ATOP),

       (PorterDuff.Mode.DST),
       (PorterDuff.Mode.DST_IN),
       (PorterDuff.Mode.DST_OUT),
       (PorterDuff.Mode.DST_OVER),
       (PorterDuff.Mode.DST_ATOP),

       (PorterDuff.Mode.XOR),
       (PorterDuff.Mode.DARKEN),
       (PorterDuff.Mode.LIGHTEN),
       (PorterDuff.Mode.MULTIPLY),
       (PorterDuff.Mode.SCREEN),
    )
    private val bitmap = BitmapFactory.decodeResource(resources,R.drawable.tesst)
    var currrentXfermode:PorterDuff.Mode = PorterDuff.Mode.CLEAR
    init {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        CoroutineScope(Dispatchers.Main).launch {
            var index = 0
            while (true){
                delay(2000)
                paintXfermode.xfermode = PorterDuffXfermode(listXfermode[index])
                currrentXfermode=listXfermode[index]
                invalidate()
                index++
                if (index == listXfermode.size) index = 0
            }

        }
    }

    override fun onDraw(canvas: Canvas) {
        val centerX = width/2f
        val rectCenterY = 700f
        val circlePY = 500f
        val saveLayer = canvas.saveLayer(0f,0f, width.toFloat(), height.toFloat(),null)
        rectF.set(centerX-rectHalfSize,rectCenterY-rectHalfSize,centerX+rectHalfSize,rectCenterY+rectHalfSize)

        canvas.drawCircle(centerX, circlePY, circleRadius1, paint)

        canvas.drawBitmap(bitmap,null,rectF,paintXfermode)
        canvas.restoreToCount(saveLayer)


        val centerX2 = width/2f
        val centerY2 = height*3/4f


        val saveLayer2 = canvas.saveLayer(0f,0f, width.toFloat(), height.toFloat(),null)
        rectF.set(centerX2-rectHalfSize,centerY2-rectHalfSize,centerX2+rectHalfSize,centerY2+rectHalfSize)

        canvas.drawCircle(centerX2, centerY2, circleRadius2, paint)

        canvas.drawBitmap(bitmap,null,rectF,paintXfermode)
        paintXfermode.xfermode=null
        canvas.restoreToCount(saveLayer2)

        canvas.drawText(currrentXfermode.name,width/2f,50f,paint)

    }



}