package com.nangtech.imotion.heartrate

interface HeartRateDataEventListener {

    fun onSensorConnected()

    fun onSensorDisconnected()

    fun onNoData()

    fun onReceivedData()
}