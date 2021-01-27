package com.nangtech.imotion.heartrate.model

import com.nangtech.imotion.base.IState

data class HeartRateViewState(
    val loading: Boolean,
    val questions: List<String>?,
    val errorMessage: String?
) : IState {

    companion object {
        fun idle(): HeartRateViewState = HeartRateViewState(
            loading = false,
            questions = null,
            errorMessage = null
        )
    }
}
