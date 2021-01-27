package com.nangtech.imotion.heartrate.model

import com.nangtech.imotion.base.IAction

sealed class HeartRateAction : IAction {

    object CancelTrackingAction : HeartRateAction()
    object ConfirmBikingAction : HeartRateAction()
    object ConfirmRunningAction : HeartRateAction()
    data class ConfirmCustomActivityAction(val activityName: String) : HeartRateAction()

}
