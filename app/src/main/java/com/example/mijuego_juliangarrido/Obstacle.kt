package com.example.mijuego_juliangarrido

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Obstacle(context: Context, private var x: Float, private var y: Float, private val width: Float, private val height: Float) {

    private var paint: Paint // Estilo de dibujo

    init {
        // Estilo de dibujo del rectángulo
        paint = Paint()
        paint.color = Color.RED
    }

    fun draw(canvas: Canvas) {
        // Dibujar el rectángulo del obstáculo en la posición y dimensiones proporcionadas
        canvas.drawRect(x, y, x + width, y + height, paint)
    }

    fun update() {
        // Lógica para actualizar la posición del obstáculo
        val speed = 5f // Velocidad de descenso de los obstáculos
        y += speed // Mover hacia abajo con la velocidad especificada
        // Verificar si el obstáculo ha alcanzado la parte inferior de la pantalla
        if (y > screenHeight) {
            // Volver a colocar el obstáculo en la parte superior de la pantalla con una nueva posición aleatoria en el eje X
            x = (Math.random() * screenWidth).toFloat()
            y = 0f
        }
    }
}