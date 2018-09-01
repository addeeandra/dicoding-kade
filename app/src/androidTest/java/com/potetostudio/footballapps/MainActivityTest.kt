package com.potetostudio.footballapps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.layout_main.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testNavigationBehaviour() {
        onView(withId(R.id.nav_bottom)).check(matches(isDisplayed()))
        Thread.sleep(3000)

        onView(withText("PAST")).perform(click())
        Thread.sleep(2000)

        onView(withText("NEXT")).perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.action_search)).perform(click())
        Thread.sleep(1000)

        pressBack()
        Thread.sleep(500)

        pressBack()
        Thread.sleep(500)

        onView(withId(R.id.nav_teams)).perform(click())
        Thread.sleep(3000)

        onView(withId(R.id.action_search)).perform(click())
        Thread.sleep(1000)

        pressBack()
        Thread.sleep(500)

        pressBack()
        Thread.sleep(500)

        onView(withId(R.id.nav_favorites)).perform(click())
        Thread.sleep(3000)

        onView(withText("TEAMS")).perform(click())
        Thread.sleep(2000)

        onView(withText("MATCHES")).perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.nav_events)).perform(click())
        Thread.sleep(2000)
    }

}
