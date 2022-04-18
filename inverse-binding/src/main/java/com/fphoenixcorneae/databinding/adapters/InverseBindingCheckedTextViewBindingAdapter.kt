package com.fphoenixcorneae.databinding.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.fphoenixcorneae.databinding.widget.InverseBindingCheckedTextView

@InverseBindingAdapter(attribute = "android:checked")
fun getChecked(view: InverseBindingCheckedTextView): Boolean {
    return view.isChecked
}

@BindingAdapter(value = ["android:checkedAttrChanged"], requireAll = false)
fun setListener(view: InverseBindingCheckedTextView, checkedAttrChanged: InverseBindingListener?) {
    checkedAttrChanged?.let {
        view.inverseBindingListener = it
    }
}