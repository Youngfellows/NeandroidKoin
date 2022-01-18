package com.neandroid.koindi.impl

import com.neandroid.koindi.interfaces.ICoffeeMaker
import com.neandroid.koindi.interfaces.IHeater
import com.neandroid.koindi.interfaces.IPump


/**
 * 咖啡机
 */
class CoffeeMaker constructor(private val heater: IHeater, private val pump: IPump) : ICoffeeMaker {

    /**
     * 煮咖啡
     */
    override fun brow() {
        heater.on()
        pump.pumpDelivery()
        heater.off()
    }

}