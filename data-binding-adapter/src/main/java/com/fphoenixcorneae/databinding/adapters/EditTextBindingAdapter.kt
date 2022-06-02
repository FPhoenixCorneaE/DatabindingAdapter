package com.fphoenixcorneae.databinding.adapters

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.databinding.BindingAdapter

/**
 * 获得/清除焦点
 */
@BindingAdapter(value = ["requestFocus"], requireAll = false)
fun EditText.requestFocus(b: Boolean) {
    if (b) {
        isFocusableInTouchMode = true
        setSelection(text.length)
        requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    } else {
        clearFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
}