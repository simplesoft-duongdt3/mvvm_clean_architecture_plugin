package com.toast.comico.vn.presentation.features.profile.gift_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.toast.comico.vn.common_android.AppDispatchers
import com.toast.comico.vn.common_android.BaseViewModel
import com.toast.comico.vn.presentation.common.RequestState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GiftDetailViewModel(
        private val appDispatchers: AppDispatchers
) : BaseViewModel() {
    private var giftDetailModel =
            GiftDetailModel(
                    requestState = RequestState.INIT
            )

    val giftDetailLiveData: MutableLiveData<GiftDetailModel> =
            MutableLiveData(giftDetailModel)


    private var getGiftDetailJob: Job? = null

    private fun updateModel(model: GiftDetailModel) {
        giftDetailModel = model
        giftDetailLiveData.value = giftDetailModel
    }

    fun getGiftDetail() {
        updateModel(
                model = giftDetailModel.copy(requestState = RequestState.LOADING)
        )

        getGiftDetailJob?.cancel()
        getGiftDetailJob = viewModelScope.launch(appDispatchers.main) {
            //TODO request something here
        }
    }

    data class GiftDetailModel(
            val requestState: RequestState
    ) {
        fun isLoading() = requestState == RequestState.LOADING
    }
}