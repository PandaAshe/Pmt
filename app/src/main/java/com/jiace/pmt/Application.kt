package com.jiace.pmt

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

/**
1 * Copyright (C), 2015-2021, 武汉嘉测科技有限公司 All rights reserved.
2 * Created by wzh on 2022/2/24.
3 * Description:
4 *
5 */
class Application : android.app.Application() {

    private lateinit var preferencesDataStore: DataStore<Preferences>
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main.immediate)

    override fun onCreate() {
        super.onCreate()
        preferencesDataStore = PreferenceDataStoreFactory.create { applicationContext.preferencesDataStoreFile("settings") }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            coroutineScope.launch {
                AppCompatDelegate.setDefaultNightMode(
                    if (UserKnobs.darkTheme.first()) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
            }
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }


    companion object {

        private lateinit var weakSelf: WeakReference<Application>

        @JvmStatic
        fun get() = weakSelf.get()!!

        @JvmStatic
        fun getPreferencesDataStore() = get().preferencesDataStore

    }


    init {
        weakSelf = WeakReference(this)

    }

}