package com.fphoenixcorneae.databinding.demo.memberbenefit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MemberBenefitsViewModel : ViewModel() {
    private val _title = MutableLiveData<String?>()
    val title: LiveData<String?> = _title

    private val _currentProgress = MutableLiveData<Int>()
    val currentProgress: LiveData<Int> = _currentProgress

    private val _totalProgress = MutableLiveData<Int>()
    val totalProgress: LiveData<Int> = _totalProgress

    init {
        viewModelScope.launch {
            delay(2000)
            _title.postValue("啦啦啦啦啦")
            _currentProgress.postValue(3)
            _totalProgress.postValue(5)
        }
    }
}