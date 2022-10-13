package com.lomza.uitestsapp.tests.groceries

import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.lomza.uitestsapp.GroceriesListActivity
import com.lomza.uitestsapp.R
import com.lomza.uitestsapp.tests.assertToolbarTitle
import com.schibsted.spain.barista.assertion.BaristaAssertions.assertThatBackButtonClosesTheApp
import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Rule
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class Groceries2Steps {

    @get:Rule
    var activityRule = ActivityTestRule<GroceriesListActivity>(GroceriesListActivity::class.java, true, false)

    @Before
    fun setup() {
        try {
            Intents.init()
        } catch (e: Exception) {

        }
    }

    @After
    fun cleanup() {
        setup()
        Intents.release()
    }

    @Given("The app started 2")
    fun the_app_started2() {
        activityRule.launchActivity(Intent())
    }

    @Then("I see Groceries list screen 2")
    fun i_see_groceries_list_screen2() {
        intended(hasComponent(GroceriesListActivity::class.java.name))

        val toolbarTitle = getInstrumentation().targetContext.getString(R.string.groceries_list_activity)
        assertToolbarTitle(R.id.vGroceriesListToolbar, toolbarTitle)
        assertDisplayed(R.string.groceries_list_header)
        assertRecyclerViewItemCount(R.id.vGroceriesRecyclerView, expectedItemCount = 10)
    }

    @When("I press back 2")
    fun i_press_back2() {
        // intentionally do nothing, assertion is done in the next step
    }

    @Then("I should exit the app 2")
    fun i_should_exit_the_app2() {
        assertThatBackButtonClosesTheApp()
    }
}