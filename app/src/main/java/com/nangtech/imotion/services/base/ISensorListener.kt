package com.nangtech.imotion.services.base

interface ISensorListener<H: ISensorDataHandler> {

    val dataHandler: H

    fun register()
}