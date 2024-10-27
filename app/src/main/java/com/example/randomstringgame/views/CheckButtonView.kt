package com.example.randomstringgame.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.randomstringgame.R

@Composable
fun CheckButton(onCheckClicked: () -> Unit, clearFocus: () -> Unit) {
    Button(
        onClick = {
            clearFocus()
            onCheckClicked()
        },
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = stringResource(R.string.check_button))
    }
}