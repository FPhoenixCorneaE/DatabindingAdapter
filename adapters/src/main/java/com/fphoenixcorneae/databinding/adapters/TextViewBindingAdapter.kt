package com.fphoenixcorneae.databinding.adapters

import android.graphics.Paint
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import kotlin.math.roundToInt

/**
 * 设置文字颜色
 * Supported formats are:
 * #RRGGBB #AARRGGBB
 * The following names are also accepted: "red", "blue", "green", "black", "white", "gray", "cyan",
 * "magenta", "yellow", "lightgray", "darkgray", "grey", "lightgrey", "darkgrey", "aqua", "fuchsia",
 * "lime", "maroon", "navy", "olive", "purple", "silver", "teal".
 *
 * Throws:
 * IllegalArgumentException - if this String cannot be parsed.
 */
@BindingAdapter(value = ["textColorString", "defaultTextColor"], requireAll = false)
fun TextView.setTextColorString(colorString: String?, default: Int? = null) {
    (runCatching { colorString?.toColorInt() }.getOrNull() ?: default)?.let { color ->
        setTextColor(color)
    }
}

@BindingAdapter(value = ["maxWidthDp", "maxHeightDp"], requireAll = false)
fun TextView.setMaxWidthDp(maxWidth: Float?, maxHeight: Float?) {
    maxWidth?.let {
        setMaxWidth((it * resources.displayMetrics.density).roundToInt())
    }
    maxHeight?.let {
        setMaxHeight((it * resources.displayMetrics.density).roundToInt())
    }
}

/**
 * 添加删除线
 */
@BindingAdapter(value = ["strikeThru"], requireAll = false)
fun setStrikeThru(textView: TextView, enable: Boolean) {
    textView.paintFlags = if (enable) {
        textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}

/**
 * 添加下划线
 */
@BindingAdapter(value = ["underline"], requireAll = false)
fun setUnderline(textView: TextView, enable: Boolean) {
    textView.paintFlags = if (enable) {
        textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
    } else {
        textView.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
    }
}

/**
 * 设置粗体
 */
@BindingAdapter("isFakeBoldText")
fun setFakeBoldText(textView: TextView, isFakeBoldText: Boolean) {
    textView.paint.isFakeBoldText = isFakeBoldText
}