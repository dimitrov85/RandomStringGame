package com.example.randomstringgame

import GameViewModel
import UserInput
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.randomstringgame.ui.theme.Beige
import com.example.randomstringgame.ui.theme.RandomStringGameTheme
import com.example.randomstringgame.views.CheckButton
import com.example.randomstringgame.views.GenerateRandomString
import com.example.randomstringgame.views.SetTitle

class MainActivity : ComponentActivity() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Beige
            ) {
                RandomStringGameTheme {
                    Screen(viewModel)
                }
            }
        }
    }
}

@Composable
fun Screen(viewModel: GameViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        SetTitle(stringResource(R.string.title))
        Spacer(Modifier.height(12.dp))
        GenerateRandomString(viewModel.randomString)
        Spacer(Modifier.height(12.dp))
        UserInput(viewModel)
        Spacer(Modifier.height(12.dp))
        CheckButton(onCheckClicked = {
            viewModel.checkInputs()
        }, clearFocus = {
            keyboardController?.hide()
            focusManager.clearFocus()
        })
    }
}


