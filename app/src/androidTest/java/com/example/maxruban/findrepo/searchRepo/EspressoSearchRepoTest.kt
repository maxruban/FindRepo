package com.example.maxruban.findrepo.searchRepo

import android.app.Activity
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import com.example.maxruban.findrepo.MainActivity
import android.support.test.rule.ActivityTestRule
import com.example.maxruban.findrepo.R
import org.hamcrest.CoreMatchers.*
import org.junit.Test
import android.support.test.uiautomator.UiSelector
import com.example.maxruban.findrepo.IdlingResourceProvider
import org.junit.Assert
import org.junit.Before
import java.util.regex.Pattern
import com.jakewharton.espresso.OkHttp3IdlingResource
import android.support.test.espresso.IdlingResource
import com.example.maxruban.findrepo.OkhttpProvider
import okhttp3.OkHttpClient


/**
 * Created by maxruban on 4/1/18.
 */



open class EspressoSearchRepoTest<WebViewActivity : Activity?>
    : BaseTest()
{


    @Rule


    @JvmField


    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    val resource: IdlingResource = OkHttp3IdlingResource.create("OkHttp", OkhttpProvider.okhttpClient) // !!!!!!!!

    @Before
    fun setup(){
//        IdlingRegistry.getInstance().register(idlingRes.idlingResource)

    }

//    @Before
//    fun setUp1() {
//        IdlingRegistry.getInstance().register(IdlingResourceProvider.getResources())
//    }
//    @Before
//    fun registerIdlingResource() {
//        val mIdlingResource = mActivityRule.getActivity().getResources()
////         To prove that the test fails, omit this call:
//        IdlingRegistry.getInstance().register(IdlingResourceProvider);
//    }


    @Test

    fun verifyAppFoundRepoByWord(){



//   *******     IdlingRegistry.getInstance().register(IdlingResourceProvider.searchResulIdlingResource)
        IdlingRegistry.getInstance().register(resource) // !!!!!!!!!!!

        onView(withId(R.id.searchEditText))
                .perform(typeText("code"));
        onView(withId(R.id.searchButton))
                .perform(click())
        onData(anything())
                .inAdapterView(allOf(withId(R.id.repoListView)))
                .atPosition(0)
                .check(matches(isDisplayed()))

        IdlingRegistry.getInstance().unregister(resource) // !!!!!!!!!!!
//    *******    IdlingRegistry.getInstance().unregister(IdlingResourceProvider.searchResulIdlingResource)
    }

    @Test
    fun verifyAppFoundUsersRepoByName(){

        onView(withId(R.id.userRepoEditText))
                .perform(typeText("maxruban"));
        onView(withId(R.id.userRepoButton))
                .perform(click())
        Thread.sleep(3000)
        onData(anything())
                .inAdapterView(allOf(withId(R.id.repoListView)))
                .atPosition(0)

                .perform(ViewActions.click())
        Thread.sleep(3000)
                val url = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar")).text


        val isMatch = Pattern.matches("https://github.com.*maxruban.*", url)
        if (!isMatch){
            Assert.fail()
        }
    }



}
