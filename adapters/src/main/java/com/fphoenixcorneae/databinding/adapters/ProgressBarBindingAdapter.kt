package com.fphoenixcorneae.databinding.adapters

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ScaleDrawable
import android.os.Build
import android.widget.ProgressBar
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import kotlin.math.roundToInt

@BindingAdapter(value = ["android:backgroundTint", "backgroundTintDefault"], requireAll = false)
fun ProgressBar.setBackgroundTint(colorString: String?, default: Int?) {
    (runCatching { colorString?.toColorInt() }.getOrNull() ?: default)?.let { tintColor ->
        (progressDrawable as? LayerDrawable)?.findDrawableByLayerId(android.R.id.background)?.let {
            it.colorFilter = PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
        }
    }
}

@BindingAdapter(value = ["android:progressTint", "progressTintDefault"], requireAll = false)
fun ProgressBar.setProgressTint(colorString: String?, default: Int?) {
    (runCatching { colorString?.toColorInt() }.getOrNull() ?: default)?.let { tintColor ->
        (progressDrawable as? LayerDrawable)?.findDrawableByLayerId(android.R.id.progress)?.let {
            it.colorFilter = PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
        }
    }
}

@BindingAdapter(value = ["progressDrawableHeightDp"], requireAll = false)
fun ProgressBar.setProgressDrawableHeight(progressDrawableHeightDp: Float?) {
    progressDrawableHeightDp?.let {
        (progressDrawable as? LayerDrawable)?.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                runCatching {
                    val heightPx = (it * resources.displayMetrics.density).roundToInt()
                    for (index in 0 until numberOfLayers) {
                        setLayerHeight(index, heightPx)
                    }
                }.onFailure {
                    it.printStackTrace()
                }
            }
        }
    }
}

@BindingAdapter(value = ["progressDrawableRadiusDp"], requireAll = false)
fun ProgressBar.setProgressDrawableRadius(progressDrawableRadiusDp: Float?) {
    progressDrawableRadiusDp?.let {
        (progressDrawable as? LayerDrawable)?.apply {
            val radiusPx = it * resources.displayMetrics.density
            (findDrawableByLayerId(android.R.id.background) as? GradientDrawable)?.let {
                it.cornerRadius = radiusPx
            }
            (findDrawableByLayerId(android.R.id.progress) as? ScaleDrawable)?.let {
                (it.drawable as? GradientDrawable)?.cornerRadius = radiusPx
            }
        }
    }
}
