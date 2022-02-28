package com.jiace.pmt

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.jiace.pmt.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ThemeChangeAwareActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        mBinding.lifecycleOwner = this
        mViewModel = ViewModel().apply {
            uerName.set("MRW")
        }
        mBinding.userInfo = mViewModel

        lifecycleScope.launch {
            var count = 0
            while (true) {
                delay(1000)
                count++
                mViewModel.uerName.set("${mViewModel.uerName.get()}${count}")

                mViewModel.isVisibility.set(count % 2 == 0)
            }
        }
        mBinding.executePendingBindings()
        setContentView(mBinding.root)
    }


}