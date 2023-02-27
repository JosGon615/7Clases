package com.example.a7clases

import android.app.Application
import android.media.MediaPlayer

class MiApp : Application() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.tema)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    override fun onTerminate() {
        super.onTerminate()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}