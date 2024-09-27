package com.fphoenixcorneae.databinding.demo

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @desc：MainViewModel
 * @date：2022/04/18 11:45
 */
class MainViewModel : ViewModel() {
    val textViewChecked = MutableLiveData(false)
    val checkBoxChecked = MutableLiveData(false)

    fun onLoadMore(v: View) {
        Log.d("MainViewModel", "onLoadMore()")
        Toast.makeText(v.context, "onLoadMore()", Toast.LENGTH_SHORT).show()
    }

    fun onLongClick(v: View): Boolean {
        Log.d("MainViewModel", "onLongClick()")
        Toast.makeText(v.context, "onLongClick()", Toast.LENGTH_SHORT).show()
        // 返回 false-会继续响应 onClick(), true-不会响应 onClick()
        return false
    }

    fun onClick(v: View) {
        Log.d("MainViewModel", "onClick()")
        Toast.makeText(v.context, "onClick()", Toast.LENGTH_SHORT).show()
    }
}