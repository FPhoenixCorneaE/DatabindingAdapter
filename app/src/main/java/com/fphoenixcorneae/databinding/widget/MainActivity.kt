package com.fphoenixcorneae.databinding.widget

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.fphoenixcorneae.databinding.widget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _viewBinding: ActivityMainBinding? = null
    private val mViewBinding get() = _viewBinding!!
    private val mViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            setContentView(root)
        }
        initView()
        initObserver()
    }

    private fun initView() {
        mViewBinding.apply {
            viewModel = mViewModel
            recyclerAdapter = RecyclerViewAdapter()
            recyclerLayoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }

    private fun initObserver() {
        mViewModel.apply {
            textViewChecked.observe(this@MainActivity) {
                Log.d("inverseBinding", "textViewChecked: $it")
            }
            checkBoxChecked.observe(this@MainActivity) {
                Log.d("inverseBinding", "checkBoxChecked: $it")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}