import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.randomstringgame.ui.theme.Green
import com.example.randomstringgame.ui.theme.Orange
import com.example.randomstringgame.ui.theme.Red
import com.example.randomstringgame.ui.theme.Transparent

class GameViewModel : ViewModel() {
    private val randomStringNumber = 4
    private val _randomString = mutableStateOf(generateRandomString(randomStringNumber))
    val randomString: String get() = _randomString.value

    private val _inputLetters = mutableStateOf(listOf("", "", "", ""))
    val inputLetters: List<String> get() = _inputLetters.value

    private val _inputColors = mutableStateOf(listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent))
    val inputColors: List<Color> get() = _inputColors.value

    fun updateInputLetter(index: Int, value: String) {
        if (value.length <= 1 && value.all { it.isLetter() }) {
            val newLetters = _inputLetters.value.toMutableList()
            newLetters[index] = value.uppercase()
            _inputLetters.value = newLetters
        }
    }

    fun checkInputs() {
        _inputColors.value = inputLetters.mapIndexed { index, input ->
            when {
                input.isEmpty() -> Transparent
                input.isNotEmpty() && input == randomString[index].toString() -> Green
                input.isNotEmpty() && randomString.contains(input) -> Orange
                else -> Red
            }
        }
    }

    private fun generateRandomString(length: Int): String {
        val chars = ('A'..'Z').toList()
        return (1..length)
            .map{ chars.random()}
            .joinToString("")
    }
}


