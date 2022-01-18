package com.neandroid.koindi.di

import com.neandroid.koindi.impl.CoffeeMaker
import com.neandroid.koindi.impl.ElectricHeate
import com.neandroid.koindi.impl.SizedElectricHeater
import com.neandroid.koindi.impl.Thermosiphon
import com.neandroid.koindi.interfaces.IHeater
import com.neandroid.koindi.interfaces.IPump
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

//参考博客: https://www.jianshu.com/p/8d78761f3c6f

internal val coffeeMakerModule = module {
    single<IHeater> { ElectricHeate() }
    single<IPump> { Thermosiphon(get()) }
    single { CoffeeMaker(get(), get()) }
}

internal val coffeeMakerModule1 = module {
    single<IHeater>(named("low")) { SizedElectricHeater(1000) }
    single<IHeater>(named("hight")) { SizedElectricHeater(3000) }
    single<IPump>(named("low")) { Thermosiphon(get(named("low"))) }
    single<IPump>(named("hight")) { Thermosiphon(get(named("hight"))) }
    single(named("low")) { CoffeeMaker(get(named("low")), get(named("low"))) }
    single(named("hight")) { CoffeeMaker(get(named("hight")), get(named("hight"))) }
}

internal val coffeeMakerModule2 = module {
    scope(named("low2")) {
        scoped {
            SizedElectricHeater(1200)
        } bind (IHeater::class)
        scoped {
            Thermosiphon(get())
        } bind (IPump::class)
        scoped {
            //CoffeeMaker(get<Thermosiphon>(), get<SizedElectricHeater>())
            CoffeeMaker(get(), get())
        }
    }
    scope(named("hight2")) {
        scoped {
            SizedElectricHeater(3200)
        }.bind(IHeater::class)
        scoped {
            Thermosiphon(get())
        }.bind(IPump::class)
        scoped {
            CoffeeMaker(get(), get())
        }
    }
}

/**
 *支持传递参数
 */
internal val coffeeMakerModule3 = module {
    scope(named("my_parameter")) {
        scoped { (size: Int) ->
            SizedElectricHeater(size)
        } bind (IHeater::class)
        scoped { (size: Int) ->
            Thermosiphon(get() {
                parametersOf(size)
            })
        } bind (IPump::class)
        scoped { (size: Int) ->
            CoffeeMaker(get() { parametersOf(size) }, get() { parametersOf(size) })
        }
    }

}

