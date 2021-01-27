package com.nangtech.imotion.heartrate.model

import com.nangtech.imotion.base.IIntent

sealed class HeartRateIntent : IIntent {
    object CancelTrackingIntent : HeartRateIntent()
    object ConfirmBikingIntent : HeartRateIntent()
    object ConfirmRunningIntent : HeartRateIntent()
    object ConfirmCustomActivityIntent : HeartRateIntent()
}
