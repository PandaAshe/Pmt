package com.jiace.pmt

import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
1 * Copyright (C), 2015-2021, 武汉嘉测科技有限公司 All rights reserved.
2 * Created by wzh on 2022/2/24.
3 * Description:
4 *
5 */
object UserKnobs {

    private var DARK_THEME = booleanPreferencesKey("dark_theme")
    val darkTheme: Flow<Boolean>
        get() = Application.getPreferencesDataStore().data.map {
            it[DARK_THEME] ?: false
        }

}