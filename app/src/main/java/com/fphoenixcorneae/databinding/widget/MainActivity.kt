package com.fphoenixcorneae.databinding.widget

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fphoenixcorneae.databinding.widget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mViewBinding: ActivityMainBinding? = null
    private val mViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        mViewBinding?.apply {
            lifecycleOwner = this@MainActivity
            setContentView(root)
            viewModel = mViewModel
        }
        initObserver()
    }

    private fun initObserver() {
        mViewModel.apply {
            textViewChecked.observe(this@MainActivity) {
                Log.d("inverseBinding", "textViewChecked: $it")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewBinding = null
    }
}