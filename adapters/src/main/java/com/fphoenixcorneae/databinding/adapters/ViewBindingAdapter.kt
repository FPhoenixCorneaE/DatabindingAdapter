package com.fphoenixcorneae.databinding.adapters

import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.databinding.BindingAdapter
import kotlin.math.roundToInt

/**
 * 注意：设置"android:layout_width"、"android:layout_height"时需要设置一个default值，否则会报
 * You must supply a layout_width(或layout_height) attribute 错误。
 *
 * 示例：
 * android:layout_height="@{4f, default=wrap_content}"
 */
@BindingAdapter(
    value = [
        "android:layout_width",
        "android:layout_height",
        "android:layout_marginStart",
        "android:layout_marginTop",
        "android:layout_marginEnd",
        "android:layout_marginBottom",
    ],
    requireAll = false
)
fun View.setLayoutAttrs(
    widthDp: Float?,
    heightDp: Float?,
    marginStartDp: Float?,
    marginTopDp: Float?,
    marginEndDp: Float?,
    marginBottomDp: Float?,
) {
    widthDp?.let {
        updateLayoutParams {
            width = (it * resources.displayMetrics.density).roundToInt()
        }
    }
    heightDp?.let {
        updateLayoutParams {
            height = (it * resources.displayMetrics.density).roundToInt()
        }
    }
    marginStartDp?.let {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginStart = (it * resources.displayMetrics.density).roundToInt()
        }
    }
    marginTopDp?.let {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = (it * resources.displayMetrics.density).roundToInt()
        }
    }
    marginEndDp?.let {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginEnd = (it * resources.displayMetrics.density).roundToInt()
        }
    }
    marginBottomDp?.let {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = (it * resources.displayMetrics.density).roundToInt()
        }
    }
}

/**
 * 设置可见或隐藏
 * @param visible true->可见，false->隐藏
 */
@BindingAdapter("isVisible")
fun isVisible(view: View, visible: Boolean) {
    view.isVisible = visible
}

/**
 * 设置不可见或可见
 * @param invisible true->不可见，false->可见
 */
@BindingAdapter("isInvisible")
fun isInvisible(view: View, invisible: Boolean) {
    view.isInvisible = invisible
}

/**
 * 设置是否选中
 * @param selected true->选中，false->未选中
 */
@BindingAdapter("isSelected")
fun isSelected(view: View, selected: Boolean) {
    view.isSelected = selected
}

/**
 * 设置单次点击监听
 */
@BindingAdapter(value = ["onSingleClick"], requireAll = false)
fun setOnSingleClick(
    view: View,
    onSingleClick: View.OnClickListener,
) {
    val hits = LongArray(2)
    view.setOnClickListener {
        System.arraycopy(hits, 1, hits, 0, hits.size - 1)
        hits[hits.size - 1] = SystemClock.uptimeMillis()
        if (hits[0] < SystemClock.uptimeMillis() - 500) {
            onSingleClick.onClick(it)
        }
    }
}

/**
 * 设置多次点击监听
 * @param onClickListener 点击监听
 * @param clickTimes      点击次数
 * @param duration        有效时间
 */
@BindingAdapter(
    value = [
        "onMultiClickTimes",
        "onMultiClickValidDuration",
        "onMultiClick",
    ],
    requireAll = false
)
fun setOnMultiClick(
    view: View,
    clickTimes: Int,
    duration: Long,
    onClickListener: View.OnClickListener,
) {
    var tempClickTimes = clickTimes
    if (tempClickTimes <= 2) {
        tempClickTimes = 2
    }
    var tempDuration = duration
    if (tempDuration <= 1_000) {
        tempDuration = 1_000
    }
    var hits = LongArray(tempClickTimes)
    view.setOnClickListener {
        // 将hits数组内的所有元素左移一个位置
        System.arraycopy(hits, 1, hits, 0, hits.size - 1)
        // 获得当前系统已经启动的时间
        hits[hits.size - 1] = SystemClock.uptimeMillis()
        if (hits[0] >= SystemClock.uptimeMillis() - tempDuration) {
            // 相关逻辑操作
            onClickListener.onClick(it)
            // 初始化点击次数
            hits = LongArray(tempClickTimes)
        }
    }
}

/**
 * 设置长按监听
 */
@BindingAdapter(value = ["onLongClick"], requireAll = false)
fun setOnLongClick(
    view: View,
    onLongClick: View.OnLongClickListener,
) {
    view.setOnLongClickListener {
        return@setOnLongClickListener onLongClick.onLongClick(it)
    }
}