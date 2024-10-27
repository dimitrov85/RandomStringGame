package com.example.randomstringgame.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomstringgame.R
import com.example.randomstringgame.ui.theme.Purple40

@Composable
fun SetTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 12.dp),
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.pencil),
                    contentDescription = stringResource(id = R.string.content_name_pencil),
                    Modifier.size(30.dp)
                )
            }
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = androidx.compose.material3.MaterialTheme.typography.displayLarge,
                color = Purple40,
                fontSize = 28.sp
            )
        }
    }
}