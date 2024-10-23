package com.fphoenixcorneae.databinding.demo.memberbenefit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fphoenixcorneae.databinding.demo.databinding.FragmentMemberBenefitsBinding

class MemberBenefitsFragment : Fragment() {

    private val mViewModel by viewModels<MemberBenefitsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMemberBenefitsBinding.inflate(inflater, container, false).apply {
            viewModel = mViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }
}