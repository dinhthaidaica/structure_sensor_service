package com.nangtech.imotion.services.base

import com.nangtech.imotion.services.base.IRepository

interface ISensorDataHandler {

    val repository: IRepository

    fun onNoData()

    fun onDisconnected()

    fun onConnected()

    fun onDataReceived()

}