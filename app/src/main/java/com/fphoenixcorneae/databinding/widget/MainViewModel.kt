package com.fphoenixcorneae.databinding.widget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @desc：MainViewModel
 * @date：2022/04/18 11:45
 */
class MainViewModel : ViewModel() {
    val textViewChecked = MutableLiveData(true)
}