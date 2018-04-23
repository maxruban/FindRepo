package com.example.maxruban.findrepo

import android.support.test.espresso.IdlingResource

/**
 * Created by maxruban on 4/22/18.
 */
open class EspressoIdlingResource {

    private val RESOURCE = "GLOBAL"

    private var mCountingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

    val idlingResource: IdlingResource
        get() = mCountingIdlingResource

    open fun increment() {
        mCountingIdlingResource.increment()
    }

    fun decrement() {
        mCountingIdlingResource.decrement()
    }
}
