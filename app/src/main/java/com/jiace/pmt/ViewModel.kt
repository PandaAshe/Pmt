package com.jiace.pmt

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.google.android.material.snackbar.Snackbar

/**
1 * Copyright (C), 2015-2021, 武汉嘉测科技有限公司 All rights reserved.
2 * Created by wzh on 2022/2/28.
3 * Description:
4 *
5 */
class ViewModel {

    /** 用户名称 */
    var uerName: ObservableField<String> = ObservableField<String>()

    /** 密码 */
    var isVisibility: ObservableBoolean = ObservableBoolean(false)

    fun onLogin(view: View) {
        uerName.set("MRT")
        Snackbar.make(view,"点击button了",Snackbar.LENGTH_LONG).show()
    }

}