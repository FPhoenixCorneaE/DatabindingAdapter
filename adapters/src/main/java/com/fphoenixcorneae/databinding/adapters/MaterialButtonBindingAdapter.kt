package com.fphoenixcorneae.databinding.adapters

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton

/**
 * 背景着色
 * Supported formats are:
 * #RRGGBB #AARRGGBB
 * The following names are also accepted: "red", "blue", "green", "black", "white", "gray", "cyan",
 * "magenta", "yellow", "lightgray", "darkgray", "grey", "lightgrey", "darkgrey", "aqua", "fuchsia",
 * "lime", "maroon", "navy", "olive", "purple", "silver", "teal".
 *
 * Throws:
 * IllegalArgumentException - if this String cannot be parsed.
 */
@BindingAdapter("backgroundTint")
fun MaterialButton.setBackgroundTintColor(colorString: String?) {
    runCatching { colorString?.toColorInt() }.getOrNull()?.let {
        backgroundTintList = ColorStateList.valueOf(it)
    }
}

@BindingAdapter("backgroundTint")
fun MaterialButton.setBackgroundTintColor(@ColorInt tintColor: Int?) {
    tintColor?.let {
        backgroundTintList = ColorStateList.valueOf(it)
    }
}

/**
 * 设置描边颜色
 * Supported formats are:
 * #RRGGBB #AARRGGBB
 * The following names are also accepted: "red", "blue", "green", "black", "white", "gray", "cyan",
 * "magenta", "yellow", "lightgray", "darkgray", "grey", "lightgrey", "darkgrey", "aqua", "fuchsia",
 * "lime", "maroon", "navy", "olive", "purple", "silver", "teal".
 *
 * Throws:
 * IllegalArgumentException - if this String cannot be parsed.
 */
@BindingAdapter(value = ["strokeColor", "defaultStrokeColor"], requireAll = false)
fun MaterialButton.setStrokeColor(colorString: String?, defaultStrokeColor: String?) {
    runCatching { colorString?.toColorInt() ?: defaultStrokeColor?.toColorInt() }.getOrNull()?.let {
        strokeColor = ColorStateList.valueOf(it)
    }
}

@BindingAdapter(value = ["strokeColor", "defaultStrokeColor"], requireAll = false)
fun MaterialButton.setStrokeColor(colorString: String?, @ColorInt defaultStrokeColor: Int?) {
    (runCatching { colorString?.toColorInt() }.getOrNull() ?: defaultStrokeColor)?.let {
        strokeColor = ColorStateList.valueOf(it)
    }
}
