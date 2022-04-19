package com.fphoenixcorneae.databinding.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckedTextView
import androidx.appcompat.widget.AppCompatCheckedTextView

/**
 * @desc：CheckedTextView
 * @date：2022/04/18 09:49
 */
class CheckedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatCheckedTextView(context, attrs) {

    private var mOnCheckedChangeListener: OnCheckedChangeListener? = null

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        mOnCheckedChangeListener?.invoke(this, checked)
    }

    fun setOnCheckedChangeListener(onCheckedChangeListener: OnCheckedChangeListener?) {
        mOnCheckedChangeListener = onCheckedChangeListener
    }
}

typealias OnCheckedChangeListener = (checkedTextView: CheckedTextView, isChecked: Boolean) -> Unit

