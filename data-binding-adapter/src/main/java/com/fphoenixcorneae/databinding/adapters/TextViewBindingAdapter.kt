package com.fphoenixcorneae.databinding.adapters

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * 添加删除线
 */
@BindingAdapter(value = ["strikeThru"], requireAll = false)
fun setStrikeThru(textView: TextView, enable: Boolean) {
    // 添加删除线
    textView.paintFlags = if (enable) {
        textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}