package com.ceiba.parkinglot_adn

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

class PageParkingLot {

    fun selectActionAddVehicle() {
        onView(withId(R.id.rb_add)).perform(click()).check(matches(isDisplayed()))
    }

    fun selectActionSearch() {
        onView(withId(R.id.rb_search)).perform(click()).check(matches(isDisplayed()))
    }

    fun selectActionGetOut() {
        onView(withId(R.id.rb_get_out)).perform(click()).check(matches(isDisplayed()))
    }

    fun selectTypeCar() {
        onView(withId(R.id.rb_car)).perform(click()).check(matches(isDisplayed()))
    }

    fun selectTypeMotorcycle() {
        onView(withId(R.id.rb_motorcycle)).perform(click()).check(matches(isDisplayed()))
    }

    fun writeSiteInParkingLot() {
        onView(withId(R.id.et_site))
            .perform(typeText("0"))
            .perform(closeSoftKeyboard())
    }

    fun writePlate() {
        onView(withId(R.id.et_plate))
            .perform(typeText("HBC123"))
            .perform(closeSoftKeyboard())
    }

    fun writeCylindrical() {
        onView(withId(R.id.et_cylindrical))
            .perform(typeText("2000"))
            .perform(closeSoftKeyboard())
    }

    fun clickInButtonSend() {
        onView(withId(R.id.bt_send)).perform(click()).check(matches(isDisplayed()))
    }

    fun clickInButtonShowListCart() {
        onView(withId(R.id.bt_show_cars)).perform(click())
    }

    fun clickInButtonShowListMotorcycle() {
        onView(withId(R.id.bt_show_motorcycles)).perform(click())
    }

    fun clickInButtonOkInDialog() {
        try {
            onView(withText(R.string.ok)).perform(click())
        } catch (e: Exception) {

        }
    }
}