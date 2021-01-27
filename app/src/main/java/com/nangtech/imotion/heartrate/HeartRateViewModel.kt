package com.nangtech.imotion.heartrate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nangtech.imotion.base.IViewModel
import com.nangtech.imotion.heartrate.model.HeartRateIntent
import com.nangtech.imotion.heartrate.model.HeartRateViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class HeartRateViewModel : ViewModel(), IViewModel<HeartRateViewState, HeartRateIntent> {

    override val intents: Channel<HeartRateIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableLiveData<HeartRateViewState>().apply { value = HeartRateViewState.idle() }

    override val state: LiveData<HeartRateViewState>
        get() = _state

    private suspend fun notifyStateChanged(handler: suspend (newState: HeartRateViewState) -> HeartRateViewState) {
        _state.value?.let {
            _state.postValue(handler(it))
        }
    }

    private val heartRateDataEventListener = object : HeartRateDataEventListener {

        override fun onSensorConnected() {
            viewModelScope.launch { notifyStateChanged { it.copy(loading = false, questions = null, errorMessage = null) } }
        }

        override fun onSensorDisconnected() {
            viewModelScope.launch { notifyStateChanged { it.copy(loading = false, questions = null, errorMessage = "Disconnected") } }
        }

        override fun onNoData() {
            viewModelScope.launch { notifyStateChanged { it.copy(loading = false, questions = null, errorMessage = "Receiving no data") } }
        }

        override fun onReceivedData() {
            // do nothing
        }

    }

    init {
        bindService()
        listenToIntents()
    }

    private fun bindService() {
        // todo: connect @heartRateDataEventListener to listen to heart-rate-events

    }

    private fun listenToIntents() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect { intent ->
                when (intent) {
                    is HeartRateIntent.ConfirmBikingIntent -> {
                    }
                    is HeartRateIntent.ConfirmRunningIntent -> {
                    }
                    is HeartRateIntent.CancelTrackingIntent -> {
                    }
                    is HeartRateIntent.ConfirmCustomActivityIntent -> {
                    }
                }

            }
        }
    }

}