package com.example.input_controls

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val REQUEST_CODE_GALLERY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)

        val mediaController = MediaController(this)

        val pathOfVideo = Uri.parse("android.resource://$packageName/${R.raw.video}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(pathOfVideo)
        videoView.requestFocus()
        videoView.start()

        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://www.indiatoday.in/blogs-section")


        val btnAddImage: Button = findViewById(R.id.btn_image)
        imageView = findViewById(R.id.imageView)

        btnAddImage.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            if (selectedImageUri != null) {
                imageView.setImageURI(selectedImageUri)
            }
        }
    }
}




