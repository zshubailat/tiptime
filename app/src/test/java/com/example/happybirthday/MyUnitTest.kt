package com.example.happybirthday

import org.junit.Assert.assertTrue
import org.junit.Test

class MyUnitTest {
    @Test
    fun checkItems() {
        var myDice = Dice(6)
        assertTrue("The Range of the dice is out of bounds", myDice.roll() in 1..6)
    }
}