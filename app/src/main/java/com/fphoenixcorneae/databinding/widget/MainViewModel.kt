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
}