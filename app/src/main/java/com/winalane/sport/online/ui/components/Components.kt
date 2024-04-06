package com.winalane.sport.online.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.ui.workout.Sport


@Composable
fun AppButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onClick.invoke()
            }
            .background(color = MaterialTheme.colorScheme.secondary)
    ) {
        Text(
            text = text,
            modifier = modifier.padding(10.dp),
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun ContainerBox(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(30.dp))
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        content.invoke()
    }
}

@Composable
fun ItemsView(
    modifier: Modifier,
    sport: Sport
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color = if (sport.isSelected) MaterialTheme.colorScheme.secondary else Color.White)
    ) {
        Text(
            text = sport.name,
            modifier = modifier.padding(10.dp),
            color = if (sport.isSelected) Color.White else MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}