package com.neandroid.koindi.impl

import android.util.Log


/**
 * 提供高低功率的加热器
 */
class SizedElectricHeater constructor(val size: Int) : ElectricHeate() {

    /**
     * 重写on函数
     */
    override fun on() {
        //super.on()
        Log.d(TAG, "on:: heating,size=${size}")
        heating = true
    }
}