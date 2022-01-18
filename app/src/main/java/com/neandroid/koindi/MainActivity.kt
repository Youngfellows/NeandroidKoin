package com.neandroid.koindi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.neandroid.koindi.di.CoffeeApp

class MainActivity : AppCompatActivity() {

    private val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onMakeCoffee(view: View) {
        Log.d(TAG, "onMakeCoffee:: ")
        val coffeeApp: CoffeeApp = CoffeeApp()
        val maker = coffeeApp.maker
        maker.brow()
    }

    public fun onAdvMakeCoffee(view: View) {
        Log.d(TAG, "onAdvMakeCoffee:: ")
        val coffeeApp: CoffeeApp = CoffeeApp()
        val lowMaker = coffeeApp.lowMaker
        val hightMaker = coffeeApp.hightMaker
        lowMaker.brow()
        hightMaker.brow()
    }

    public fun onAdv2MakeCoffee(view: View) {
        Log.d(TAG, "onAdv2MakeCoffee:: ")
        val coffeeApp: CoffeeApp = CoffeeApp()
        val lowMaker = coffeeApp.lowMaker2
        val hightMaker = coffeeApp.hightMaker2
        lowMaker.brow()
        hightMaker.brow()
    }
}