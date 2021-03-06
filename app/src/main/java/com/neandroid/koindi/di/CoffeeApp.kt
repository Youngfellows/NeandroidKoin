package com.neandroid.koindi.di

import com.neandroid.koindi.impl.CoffeeMaker
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named


/**
 * 提供依赖注入的CoffeeApp咖啡店
 */
class CoffeeApp : KoinComponent {

    /**
     * 提供一个普通咖啡机
     */
    val maker: CoffeeMaker by inject()

    /**
     * 有两种规格，高功率和低功率的，现在咖啡店需要两台咖啡机，高低功率各一台
     */
    /**
     * 低功率咖啡机
     */
    val lowMaker: CoffeeMaker by inject(named("low"))

    /**
     * 高功率咖啡机
     */
    val hightMaker: CoffeeMaker by inject(named("hight"))


    /**
     * 低功率咖啡机1
     */
    val lowMaker2: CoffeeMaker by getKoin().getOrCreateScope("lowScope", named("low2")).inject()

    /**
     * 高功率咖啡机1
     */
    val hightMaker2 by getKoin().getOrCreateScope("highScope", named("hight2"))
        .inject<CoffeeMaker>()

    /**
     * 带参数的咖啡机
     */
    val parameterMaker by getKoin().getOrCreateScope("parameterScope", named("my_parameter"))
        .inject<CoffeeMaker>() {
            parametersOf(5555)
        }

}