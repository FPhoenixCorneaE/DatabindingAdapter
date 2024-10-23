package com.fphoenixcorneae.databinding.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner

/**
 * 自定义View设置viewModel
 * 注意：
 * 1、自定义View中ViewBinding变量必须命名为`mViewBinding`;
 * 2、xml资源文件中ViewModel变量必须命名为`viewModel`;
 * 3、想要预览，只能在`!isInEditMode`模式下`inflate` ViewBinding，
 *    在`isInEditMode`模式下解析xml资源并添加view到自定义View中。
 */
@BindingAdapter("viewModel")
fun <T : ViewModel> View.bindViewModel(viewModel: T) {
    runCatching {
        if (isInEditMode) return@runCatching
        val viewBindingField = runCatching {
            // 获取mViewBinding成员变量
            this.javaClass.getDeclaredField("mViewBinding")
        }.getOrNull()
        if (viewBindingField != null) {
            viewBindingField.isAccessible = true
            val viewBindingType = viewBindingField.type
            // 获取ViewDataBinding实现类的对象
            val viewBindingInstance = viewBindingField.get(this)
            // 获取ViewDataBinding的setViewModel()方法
            val setViewModelMethod =
                viewBindingType.getDeclaredMethod("setViewModel", viewModel::class.java)
            setViewModelMethod.isAccessible = true
            setViewModelMethod.invoke(viewBindingInstance, viewModel)
            // 获取ViewDataBinding的setLifecycleOwner()方法
            val setLifecycleOwnerMethod = ViewDataBinding::class.java.getDeclaredMethod(
                "setLifecycleOwner",
                LifecycleOwner::class.java
            )
            setLifecycleOwnerMethod.isAccessible = true
            setLifecycleOwnerMethod.invoke(viewBindingInstance, findViewTreeLifecycleOwner())
        }
        if (this is ViewGroup) {
            children.forEach {
                it.bindViewModel(viewModel)
            }
        }
    }.onFailure {
        Log.e("bindViewModel", it.toString())
    }
}