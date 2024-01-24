package com.example.mijuego_juliangarrido

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Player(context: Context) {

    private var x: Float // Posición en el eje X
    private var y: Float // Posición en el eje Y
    private var radius: Float // Radio del círculo
    private var paint: Paint // Estilo de dibujo

    init {
        // Posición inicial del jugador y radio del círculo
        x = 100f
        y = 100f
        radius = 50f

        // Estilo de dibujo del círculo
        paint = Paint()
        paint.color = Color.BLUE
    }

    fun draw(canvas: Canvas) {
        // Dibujar el círculo del jugador en la posición actual
        canvas.drawCircle(x, y, radius, paint)
    }

    fun update(targetX: Float) {
        // Lógica para actualizar la posición del jugador
        // Mover el jugador hacia la posición horizontal especificada (targetX)
        val speed = 10f // Velocidad de movimiento del jugador
        if (targetX < x) {
            x -= speed // Mover hacia la izquierda
        } else if (targetX > x) {
            x += speed // Mover hacia la derecha
        }
        // Asegurarse de que el jugador no salga de los límites de la pantalla
        if (x < radius) {
            x = radius
        } else if (x > screenWidth - radius) {
            x = screenWidth - radius
        }
    }

    fun getX(): Float {
        return x
    }

    fun getY(): Float {
        return y
    }
}