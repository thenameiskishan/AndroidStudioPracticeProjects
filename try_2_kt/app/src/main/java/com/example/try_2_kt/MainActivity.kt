
package com.example.try_2_kt

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning id of the button
        // which zoom in the image
        val buttonZoomIn: Button = findViewById(R.id.zoomInButton)

        // assigning id of the button
        // which zoom out the image
        val buttonZoomOut: Button = findViewById(R.id.zoomOutButton)

        // assigning id of imageview on
        // which zoom in/out will be performed
        val image: ImageView = findViewById(R.id.imageView)

        // actions to be performed when
        // "Zoom In" button is clicked
        buttonZoomIn.setOnClickListener() {

            // loading the animation of
            // zoom_in.xml file into a variable
            val animZoomIn = AnimationUtils.loadAnimation(this,
                R.anim.zoom_in)
            // assigning that animation to
            // the image and start animation
            image.startAnimation(animZoomIn)
        }

        // actions to be performed when
        // "Zoom Out" button is clicked
        buttonZoomOut.setOnClickListener() {

            // loading the animation of
            // zoom_out.xml file into a variable
            val animZoomOut = AnimationUtils.loadAnimation(this,
                R.anim.zoom_out)

            // assigning that animation to
            // the image and start animation
            image.startAnimation(animZoomOut)
        }
    }
}