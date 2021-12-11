package com.example.universityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


import android.media.MediaPlayer
import android.net.Uri
import android.os.Looper
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.content.ContextCompat.startActivity
import com.example.universityapp.utils.LoadingIcon
//import com.example.universityapp.utils.LoadingIcon
import java.util.*


class SplashActivity : AppCompatActivity() {

    var videoView : VideoView? = null

    var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        val loading = LoadingIcon(this)
//        loading.startLoading()


        videoView = findViewById<View>(R.id.videoView) as VideoView?

        if (mediaController == null) {
            var mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(
            Uri.parse(
                "android.resource://" + packageName + "/" + R.raw.jsuintro
            )
        )
        videoView!!.requestFocus()
        videoView!!.start()


        val song: MediaPlayer = MediaPlayer.create(this, R.raw.jsu)

        supportActionBar?.hide()
        song.start()


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            finish()
            song.stop()
            videoView?.stopPlayback()
            startActivity(intent)
//            loading.isDone()
        },40000)

//        if(!song.isPlaying)  song.release()
//        startActivity(intent)

//        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//
//            startActivity(intent)
//            song.release()
//            videoView?.stopPlayback()
//            finish()
//
//        }, 40000)
    }
}