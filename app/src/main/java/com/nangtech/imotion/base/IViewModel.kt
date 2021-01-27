package com.nangtech.imotion.base

import androidx.lifecycle.LiveData
import kotlinx.coroutines.channels.Channel

interface IViewModel<S : IState, I : IIntent> {

    val intents: Channel<I>

    val state: LiveData<S>
}