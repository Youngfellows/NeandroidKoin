package com.neandroid.koindi.impl

import android.util.Log
import com.neandroid.koindi.interfaces.IHeater


/**
 * 电子加热器
 */
open class ElectricHeate : IHeater {

    protected val TAG: String = this.javaClass.simpleName

    /**
     * 是否加载
     */
    protected var heating: Boolean = false

    /**
     * 开
     */
    override fun on() {
        heating = true
        Log.d(TAG, "on:: heating:${heating}")
    }

    /**
     * 关闭
     */
    override fun off() {
        heating = false
        Log.d(TAG, "off:: heating:${heating}")
    }

    /**
     * 是否加热
     */
    override fun isHot(): Boolean {
        return heating
    }
}