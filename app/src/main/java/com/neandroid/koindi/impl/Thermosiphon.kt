package com.neandroid.koindi.impl

import android.util.Log
import com.neandroid.koindi.interfaces.IHeater
import com.neandroid.koindi.interfaces.IPump


/**
 * 热虹吸式再沸器
 */
class Thermosiphon constructor(private val heater: IHeater) : IPump {

    private val TAG: String = this.javaClass.simpleName

    override fun pumpDelivery() {
        Log.d(TAG, "pumpDelivery:: ")
        if (heater.isHot()) {
            Log.d(TAG, "pumpDelivery:: pumping ...")
        }
    }
}