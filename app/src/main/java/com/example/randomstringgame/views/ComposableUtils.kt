package com.example.randomstringgame.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.randomstringgame.ui.theme.Purple40

@Composable
fun GenerateRandomString(randomString: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = randomString,
            textAlign = TextAlign.Center,
            style = androidx.compose.material3.MaterialTheme.typography.displayLarge,
            color = Purple40
        )
    }
}
