package com.toast.comico.vn.presentation.features.profile.gift_detail.di

import com.toast.comico.vn.presentation.features.profile.gift_detail.viewmodel.GiftDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val giftDetailModule = module {

    viewModel {
        GiftDetailViewModel(appDispatchers = get())
    }
}