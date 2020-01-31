package com.anwesh.uiprojects.bilinedotbouncystepview

/**
 * Created by anweshmishra on 31/01/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val lines : Int = 2
val rFactor : Float = 15f
val scGap : Float = 0.02f
val strokeFactor : Float = 90f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#283593")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBilineDot(i : Int, scale : Float, w : Float, paint : Paint) {
    val sf : Float = scale.sinify().divideScale(i, lines)
    var sj : Float = 1f - 2 * i
    val r : Float = w / rFactor
    val x : Float = (w / 2 - r) * sf * sj
    save()
    translate(0f, 0f)
    drawLine(0f, 0f, x, 0f, paint)
    drawCircle(x + r * sj, 0f, r, paint)
    restore()
}

fun Canvas.drawBiLineDots(scale : Float, w : Float, paint : Paint) {
    for (j in 0..(lines - 1)) {
        drawBilineDot(j, scale, w, paint)
    }
}

fun Canvas.drawBLDSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(0f, gap * (i + 1))
    drawBiLineDots(scale, w, paint)
    restore()
}

class BiLineDotBouncyStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}