package com.nangtech.imotion.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.nangtech.imotion.services.base.IDataCollectorService
import com.nangtech.imotion.services.base.ISensorDataHandler
import com.nangtech.imotion.services.base.ISensorListener

abstract class PhoneDataCollectorService<H : ISensorDataHandler, L : ISensorListener<H>>: Service(), IDataCollectorService<H, L> {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}