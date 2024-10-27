package com.example.randomstringgame.unitTesting

import GameViewModel
import androidx.compose.ui.graphics.Color
import com.example.randomstringgame.ui.theme.Green
import com.example.randomstringgame.ui.theme.Orange
import com.example.randomstringgame.ui.theme.Red
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameViewModelUnitTests {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setUp() {
        viewModel = GameViewModel()
    }

    @Test
    fun testRandomStringIsGeneratedCorrectly() {
        // Check if the length of the string is correct
        assertEquals(4, viewModel.randomString.length)
    }

    @Test
    fun testUpdatingInputLetters() {
        // Update input letter at index 0
        viewModel.updateInputLetter(0, "A")
        assertEquals("A", viewModel.inputLetters[0])

        // Update input letter at index 1 with invalid input
        viewModel.updateInputLetter(1, "AB")
        assertEquals("", viewModel.inputLetters[1])

        // Update with an invalid input (not within A..Z)
        viewModel.updateInputLetter(2, "1")
        assertEquals("", viewModel.inputLetters[2])
    }

    @Test
    fun testCheckInputsForCorrectColors() {
        // Set up the random string and input letters
        viewModel.updateInputLetter(0, viewModel.randomString[0].toString())
        viewModel.updateInputLetter(1, "B")
        viewModel.updateInputLetter(2, viewModel.randomString[2].toString())
        viewModel.updateInputLetter(3, "")

        viewModel.checkInputs()
        val colors = viewModel.inputColors

        assertEquals(Green, colors[0]) // Correct letter in the exact position
        if (viewModel.randomString.contains("B")) {
            assertEquals(Orange, colors[1]) // Exists in random string but not in the exact position
        } else {
            assertEquals(Red, colors[1]) // Does not exist in random string
        }
        assertEquals(Green, colors[2]) // Correct letter in the exact position
        assertEquals(Color.Transparent, colors[3]) // Empty input
    }

    @Test
    fun testInputLettersAreInitializedCorrectly() {
        assertEquals(listOf("", "", "", ""), viewModel.inputLetters)
    }

    @Test
    fun testInputColorsAreInitializedCorrectly() {
        assertTrue(viewModel.inputColors.all { it == Color.Transparent })
    }
}
