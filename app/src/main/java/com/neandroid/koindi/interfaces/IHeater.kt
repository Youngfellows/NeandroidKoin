package com.neandroid.koindi.interfaces


/**
 * 加热器
 */
interface IHeater {

    /**
     * 开
     */
    fun on()

    /**
     * 关
     */
    fun off()

    /**
     * 是否加热
     */
    fun isHot(): Boolean

}