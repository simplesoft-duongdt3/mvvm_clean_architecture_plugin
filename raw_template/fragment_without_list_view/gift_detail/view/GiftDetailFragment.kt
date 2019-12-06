package com.toast.comico.vn.presentation.features.profile.gift_detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import com.toast.comico.vn.common_android.BaseFragment
import com.toast.comico.vn.common_android.BaseViewModel
import com.toast.comico.vn.databinding.FragmentGiftDetailBinding
import com.toast.comico.vn.presentation.features.profile.gift_detail.viewmodel.GiftDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GiftDetailFragment : BaseFragment() {
    private lateinit var giftDetailBinding: FragmentGiftDetailBinding
    private val giftDetailViewModel: GiftDetailViewModel by viewModel()

    override fun getViewModel(): BaseViewModel? {
        return giftDetailViewModel
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        giftDetailBinding = FragmentGiftDetailBinding.inflate(inflater, container, false)
        giftDetailBinding.lifecycleOwner = viewLifecycleOwner
        giftDetailBinding.giftDetailViewModel = giftDetailViewModel
        return giftDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        giftDetailViewModel.getGiftDetail()
    }

    private fun initView() {
        //TODO setup view, event click... here
    }

    companion object {
        fun newInstance(): GiftDetailFragment {
            val args = Bundle()
            val fragment = GiftDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    object Binding {
        @BindingAdapter("setGiftDetail")
        @JvmStatic
        fun setGiftDetail(
                view: View,
                giftDetailModel: GiftDetailViewModel.GiftDetailModel
        ) {
            //TODO binding model here
        }
    }

}