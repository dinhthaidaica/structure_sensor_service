package com.nangtech.imotion.heartrate

import com.nangtech.imotion.services.base.ISensorDataHandler
import com.nangtech.imotion.services.repository.HeartRateRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class HeartRateDataHandler: ISensorDataHandler, KoinComponent {

    override val repository: HeartRateRepository by inject()

    private val observers = mutableListOf<HeartRateDataEventListener>()

    override fun onNoData() {
        emitEventsNoData()
    }

    override fun onDisconnected() {
        emitEventsDisConnected()
    }

    override fun onConnected() {
        emitEventsConnected()
    }

    override fun onDataReceived() {
        handleReceivedData()
    }

    fun registerDataEvents(observer: HeartRateDataEventListener) {
        observers.add(observer)
    }

    private fun emitEventsNoData() {

    }

    private fun emitEventsConnected() {

    }

    private fun emitEventsDisConnected() {

    }

    private fun handleReceivedData() {
        repository.syncData()
    }
}