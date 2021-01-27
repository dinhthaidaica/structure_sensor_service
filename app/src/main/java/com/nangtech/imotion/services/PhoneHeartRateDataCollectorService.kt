package com.nangtech.imotion.services

import com.nangtech.imotion.heartrate.HeartRateDataHandler
import com.nangtech.imotion.heartrate.HeartRateSensorListener
import org.koin.android.ext.android.inject

class PhoneHeartRateDataCollectorService: PhoneDataCollectorService<HeartRateDataHandler, HeartRateSensorListener>() {

    override val sensorListener: HeartRateSensorListener by inject()
}