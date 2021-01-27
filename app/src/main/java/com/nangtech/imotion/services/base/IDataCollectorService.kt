package com.nangtech.imotion.services.base

interface IDataCollectorService<H : ISensorDataHandler, L : ISensorListener<H>> {

    val sensorListener: L
}