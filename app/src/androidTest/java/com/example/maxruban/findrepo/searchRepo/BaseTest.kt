package com.example.maxruban.findrepo.searchRepo

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import org.junit.Before

/**
 * Created by maxruban on 4/11/18.
 */
open class BaseTest {
    protected lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    }

}