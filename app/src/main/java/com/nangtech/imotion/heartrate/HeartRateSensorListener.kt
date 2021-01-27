package com.nangtech.imotion.heartrate

import com.nangtech.imotion.services.base.ISensorListener
import org.koin.core.KoinComponent
import org.koin.core.inject

class HeartRateSensorListener: ISensorListener<HeartRateDataHandler>, KoinComponent {

    override val dataHandler: HeartRateDataHandler by inject()

    override fun register() {
        // TODO("Register to observe data from sensor here")
        // then use $dataHandler to process data
    }
}