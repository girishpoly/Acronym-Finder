package com.acronymtest.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.acronymtest.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AcronymFragmentTest: TestCase() {

    private lateinit var scenario: FragmentScenario<AcronymFragment>

    @Before
    fun setup(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AcronymTest)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testAcronymSearch(){
        val searchText = "USA"
        onView(withId(R.id.acronym_search)).perform(typeText(searchText))
        Espresso.closeSoftKeyboard()
        Thread.sleep(2000)
        onView(withId(R.id.acronym_list)).check(matches(isDisplayed()))
        onView(withId(R.id.acronym_search)).perform(typeText(""))
    }

}