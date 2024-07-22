package com.namdp.customview.watermelon

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val watermelonLayout = WatermelonLayout()
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        watermelonLayout.setSize(w, h)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        watermelonLayout.draw(canvas)
    }
    init {
        CoroutineScope(Dispatchers.Main).launch {
            var length = 0f
            while (true){
                delay(16)
                length+=10
                watermelonLayout.update(length, 3000f)
                invalidate()
            }
        }
    }
}