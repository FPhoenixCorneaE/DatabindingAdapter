package com.fphoenixcorneae.databinding.widget

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @desc：MainViewModel
 * @date：2022/04/18 11:45
 */
class MainViewModel : ViewModel() {
    val textViewChecked = MutableLiveData(false)
    val checkBoxChecked = MutableLiveData(false)

    fun onLoadMore() {
        Log.d("MainViewModel", "onLoadMore()")
    }

    fun onLongClick(): Boolean {
        Log.d("MainViewModel", "onLongClick()")
        // 返回 false-会继续响应 onClick(), true-不会响应 onClick()
        return false
    }

    fun onClick() {
        Log.d("MainViewModel", "onClick()")
    }
}