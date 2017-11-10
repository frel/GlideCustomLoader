package com.subgarden.glidecustomloader

import android.graphics.Color.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val palette = Palette(RED, GREEN, BLUE, YELLOW)

        GlideApp.with(this)
                .load(palette)
                .into(imageView)
    }
}
