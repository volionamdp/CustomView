package com.namdp.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val matrix1 = Matrix()
    private val matrix2 = Matrix()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    private val rectF: RectF = RectF()

    init {
        rectF.set(0f, 0f, 200f, 200f)
        matrix1.postRotate(45f, rectF.width() / 2f, rectF.height() / 2f)
        matrix1.postTranslate(800f, 800f)
        matrix2.postTranslate(500f, 500f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.setMatrix(matrix2)
        canvas.drawRect(rectF, paint)
        canvas.restore()

        canvas.save()
        canvas.setMatrix(matrix1)
        canvas.drawRect(rectF, paint)
        canvas.restore()

        canvas.drawRect(rectF, paint)

    }
}