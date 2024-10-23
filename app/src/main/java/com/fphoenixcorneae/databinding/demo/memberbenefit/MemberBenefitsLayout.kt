package com.fphoenixcorneae.databinding.demo.memberbenefit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.fphoenixcorneae.databinding.demo.R
import com.fphoenixcorneae.databinding.demo.databinding.LayoutMemberBenefitsBinding

class MemberBenefitsLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private lateinit var mViewBinding: LayoutMemberBenefitsBinding

    init {
        if (isInEditMode) {
            removeAllViews()
            LayoutInflater.from(context).inflate(R.layout.layout_member_benefits, this, false)
                .let {
                    addView(it, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
                }
        } else {
            mViewBinding =
                LayoutMemberBenefitsBinding.inflate(LayoutInflater.from(context), this, true)
        }
    }
}