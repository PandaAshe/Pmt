package com.jiace.pmt

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
1 * Copyright (C), 2015-2021, 武汉嘉测科技有限公司 All rights reserved.
2 * Created by wzh on 2022/2/24.
3 * Description:
4 *
5 */
abstract class ThemeChangeAwareActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
            UserKnobs.darkTheme.onEach {
                val newMode = if (it) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }

                if (AppCompatDelegate.getDefaultNightMode() != newMode) {
                    AppCompatDelegate.setDefaultNightMode(newMode)
                    recreate()
                }
            }.launchIn(lifecycleScope)
        }
    }


}