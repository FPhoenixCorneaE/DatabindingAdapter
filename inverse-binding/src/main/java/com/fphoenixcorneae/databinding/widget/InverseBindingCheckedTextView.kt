package com.fphoenixcorneae.databinding.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckedTextView
import androidx.databinding.InverseBindingListener

/**
 * @desc：InverseBindingCheckedTextView
 * @date：2022/04/18 09:49
 */
class InverseBindingCheckedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatCheckedTextView(context, attrs) {

    var onCheckedChangeListener: OnCheckedChangeListener? = null
    var inverseBindingListener: InverseBindingListener? = null

    init {
        onCheckedChangeListener = object : OnCheckedChangeListener() {
            override fun onCheckedChanged(checkedTextView: InverseBindingCheckedTextView, checked: Boolean) {
                oldValue = checked
                inverseBindingListener?.onChange()
            }
        }
    }

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if (onCheckedChangeListener?.oldValue != checked) {
            onCheckedChangeListener?.onCheckedChanged(this, checked)
        }
    }

    abstract class OnCheckedChangeListener {
        var oldValue: Boolean = false
        abstract fun onCheckedChanged(checkedTextView: InverseBindingCheckedTextView, checked: Boolean)
    }
}

