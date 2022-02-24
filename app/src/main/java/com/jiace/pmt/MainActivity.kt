package com.jiace.pmt

import android.os.Bundle

class MainActivity : ThemeChangeAwareActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}