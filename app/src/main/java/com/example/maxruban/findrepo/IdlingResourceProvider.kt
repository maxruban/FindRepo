package com.example.maxruban.findrepo

import android.support.test.espresso.IdlingResource
import android.support.test.espresso.idling.CountingIdlingResource

/**
 * Created by maxruban on 4/22/18.
 */
object IdlingResourceProvider {

    val searchResulIdlingResource = CountingIdlingResource("name")
    val searchResulIdlingResource2 = CountingIdlingResource("name2")


}
