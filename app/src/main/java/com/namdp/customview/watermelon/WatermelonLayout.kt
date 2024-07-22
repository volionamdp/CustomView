package com.namdp.customview.watermelon

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.util.Log
import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.hypot
import kotlin.math.min

data class Test(
    val rect: RectF,
    var startAngle: Float = 180f,
    var sweepAngle: Float = 0f,
    var angleX: Float = 0f,
    var angleY: Float = 0f
)

class WatermelonLayout {
    private var data = WatermelonModel()
    private var matrix = Matrix()
    private var viewWidth = 1
    private var viewHeight = 1
    private val listTest: MutableList<Test> = mutableListOf()
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }
    private var painLine = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    fun setData(watermelonModel: WatermelonModel) {
        data = watermelonModel
        listTest.clear()
        data.steps.forEach {
            val position = data.listPosition[it]
            listTest.add(
                Test(
                    RectF(
                        position.x - position.radius,
                        position.y - position.radius,
                        position.x + position.radius,
                        position.y + position.radius
                    )
                )
            )
        }
        updateMatrix()
    }

    fun setSize(width: Int, height: Int) {
        viewWidth = width
        viewHeight = height
        updateMatrix()
    }

    private fun updateMatrix() {
        val scale =
            min(viewWidth.toFloat() / data.layoutWidth, viewHeight.toFloat() / data.layoutHeight)
        matrix.setTranslate(
            viewWidth / 2f - data.layoutWidth / 2f,
            viewHeight / 2f - data.layoutHeight / 2f
        )
        matrix.postScale(scale, scale, viewWidth / 2f, viewHeight / 2f)
    }

    fun draw(canvas: Canvas) {
        canvas.save()
        canvas.setMatrix(matrix)
        painLine.alpha = 50
        listTest.forEach { test ->
            canvas.drawArc(test.rect, test.startAngle, test.sweepAngle, false, painLine)
        }
        canvas.restore()
//        canvas.drawArc(100f, 100f, 400f, 400f, 180f, 30f, false, painLine)
    }

    fun update(
        updateLength: Float,
        totalLength: Float,
        currentStep: Int = 0,
        currentLength: Float = 0f
    ) {
        if (currentStep < data.steps.size) {
            val currentPosition = data.listPosition[data.steps[currentStep]]
            var angle = 0f
            if (currentStep < data.steps.size - 1) {
                val nextPosition = data.listPosition[data.steps[currentStep + 1]]
                val position = getPosition(
                    currentPosition.x,
                    currentPosition.y,
                    nextPosition.x,
                    nextPosition.y,
                    currentPosition.radius
                )
                listTest[currentStep + 1].startAngle =
                    calculateAngle(nextPosition.x, nextPosition.y, position.x, position.y)
                angle = calculateAngle(currentPosition.x, currentPosition.y, position.x, position.y)
            } else {
                angle = 180f
            }

            val newLength = updateLength - currentLength
            val sweepAngle = (newLength / (Math.PI * 2f * currentPosition.radius) * 360).toFloat()
            val currentTest = listTest[currentStep]
            if (currentStep % 2 == 0) {
                if (angle < currentTest.startAngle) angle += 360
                if ((currentTest.startAngle + sweepAngle) < angle && sweepAngle <= 360) {
                    currentTest.sweepAngle = sweepAngle
                } else {
                    currentTest.sweepAngle = angle - currentTest.startAngle
                    val length =
                        currentLength + abs((currentTest.sweepAngle / 360) * 2 * Math.PI * currentPosition.radius)
                    if (updateLength - length > 1) {
                        update(updateLength, totalLength, currentStep + 1, length.toFloat())
                    }
                }
            } else {
                if (angle > currentTest.startAngle){
                    angle -= 360
                    Log.d("sssetc", "update: $angle  ${currentTest.startAngle}")
                }
                if ((currentTest.startAngle - sweepAngle) > angle && sweepAngle <= 360) {
                    currentTest.sweepAngle = -sweepAngle
                } else {

                    currentTest.sweepAngle = angle - currentTest.startAngle
                    val length =
                        currentLength + abs((currentTest.sweepAngle / 360) * 2 * Math.PI * currentPosition.radius)
                    if (updateLength - length > 1) {
                        update(updateLength, totalLength, currentStep + 1, length.toFloat())
                    }

                }
            }
        }
    }

    private fun getPosition(x1: Float, y1: Float, x2: Float, y2: Float, distance: Float): PointF {
        val distanceP1P2 = hypot(x1 - x2, y1 - y2)
        return PointF(
            x1 + (distance / distanceP1P2) * (x2 - x1),
            y1 + (distance / distanceP1P2) * (y2 - y1)
        )
    }

    private fun normalizationAngle(angle: Float): Float {
        val newAngle = angle % 361
        return if (newAngle < 0) {
            newAngle + 360
        } else if (newAngle > 360) {
            newAngle - 360
        } else {
            newAngle
        }
    }

    private fun calculateAngle(cx: Float, cy: Float, x: Float, y: Float): Float {
        if (x == cx) {
            return if (y > cy) 90f
            else 270f
        }
        if (y == cy) {
            return if (x > cx) 0f
            else 180f
        }
        if (x > cx && y > cy) {
            return Math.toDegrees(atan(((y - cy) / (x - cx)).toDouble())).toFloat()
        }
        if (x < cx && y > cy) {
            return 180 + Math.toDegrees(atan(((y - cy) / (x - cx)).toDouble())).toFloat()

        }
        if (x < cx && y < cy) {
            return 180 + Math.toDegrees(atan(((y - cy) / (x - cx)).toDouble())).toFloat()
        }
        if (x > cx && y < cy) {
            return 360 + Math.toDegrees(atan(((y - cy) / (x - cx)).toDouble())).toFloat()
        }
        return 0f
    }

    init {
        setData(
            WatermelonModel(
                listPosition = mutableListOf(
                    WatermelonPosition(177 + 200f, 426 + 200f, 200f),
                    WatermelonPosition(33 + 200f, 805 + 200f, 200f),
                    WatermelonPosition(446 + 200f, 737 + 200f, 200f),

                    ),
                steps = mutableListOf(0, 1, 2, 1, 0)
            )
        )
//        update(3600f, 1000f)
//        update(1600f, 1000f)
    }
}