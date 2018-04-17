package com.example.maxruban.findrepo.searchRepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.util.Log
import org.junit.Before

/**
 * Created by maxruban on 4/11/18.
 */

class BaseScreen {

    protected lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    }
}



