import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomstringgame.ui.theme.Purple40

@Composable
fun UserInput(viewModel: GameViewModel) {
    val inputLetters = viewModel.inputLetters
    val inputColors = viewModel.inputColors
    val focusRequesters = remember { List(4) { FocusRequester() } }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        inputLetters.forEachIndexed { index, value ->
            OutlinedTextField(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .background(inputColors[index])
                    .focusRequester(focusRequesters[index]),
                value = value,
                onValueChange = { newValue ->
                    viewModel.updateInputLetter(index, newValue)

                    if (newValue.length == 1 && newValue.all { it.isLetter() }) {
                        if (index < focusRequesters.size - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    }
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Purple40
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Characters,
                    imeAction = if (index < focusRequesters.size - 1) ImeAction.Next else ImeAction.Done
                ),
                visualTransformation = VisualTransformation.None
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }
}


