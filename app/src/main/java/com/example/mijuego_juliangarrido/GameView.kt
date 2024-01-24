package com.example.mijuego_juliangarrido

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context) : SurfaceView(context), Runnable {

    private var surfaceHolder: SurfaceHolder = holder
    private var isPlaying: Boolean = false
    private var thread: Thread
    private var player: Player
    private var obstacles: ArrayList<Obstacle>
    private var paint: Paint
    private var score: Int = 0
    private var isGameOver: Boolean = false

    init {
        player = Player(context)
        obstacles = ArrayList()
        paint = Paint()

        // Agregar obstáculos iniciales
        obstacles.add(Obstacle(context))
        // Agregar más obstáculos según la lógica del juego

        thread = Thread(this)
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                stopGame()
            }

            override fun surfaceCreated(holder: SurfaceHolder) {
                startGame()
            }
        })

        setOnTouchListener { _, event ->
            // Lógica para mover al jugador según el evento de toque
            true
        }
    }

    override fun run() {
        while (isPlaying) {
            update()
            draw()
            control()
        }
    }

    private fun update() {
        // Actualizar la posición de los actores, gestionar colisiones, puntuación, etc.
    }

    private fun draw() {
        if (surfaceHolder.surface.isValid) {
            val canvas: Canvas = surfaceHolder.lockCanvas()
            canvas.drawColor(Color.BLACK) // Fondo negro

            // Dibujar al jugador, obstáculos, puntuación, etc.

            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    private fun control() {
        // Ajustar la velocidad de actualización del juego
    }

    fun pause() {
        isPlaying = false
        thread.join()
    }

    fun resume() {
        isPlaying = true
        thread = Thread(this)
        thread.start()
    }

    private fun startGame() {
        isPlaying = true
        thread.start()
    }

    private fun stopGame() {
        isPlaying = false
        thread.join()
    }
}