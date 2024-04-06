package com.winalane.sport.online.ui.progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R
import com.winalane.sport.online.ui.components.ContainerBox
import com.winalane.sport.online.ui.components.ItemsView
import com.winalane.sport.online.ui.workout.Sport

@Composable
fun ProgressScreen(modifier: Modifier) {
    var listSports = mutableListOf<Sport>(
        Sport(name = "Soccer", isSelected = true),
        Sport(name = "Bicycle"),
        Sport(name = "Running"),
        Sport(name = "Push-ups"),
        Sport(name = "Press"),
        Sport(name = "Bench Pull"),
        Sport(name = "Bench Press")

    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {


        ContainerBox(modifier = modifier) {
            Column(
                modifier = modifier
                    .padding(vertical = 10.dp, horizontal = 5.dp)
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = modifier
                ) {
                    items(listSports) { item ->
                        ItemsView(modifier = modifier, sport = item)
                    }
                }

                Spacer(modifier = modifier.height(10.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(2) {
                        ProgressViewItem(modifier = modifier)
                    }
                }


                Box(
                    modifier = modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = modifier,
                        alignment = Alignment.Center,

                        painter = painterResource(id = R.drawable.no_exercise),
                        contentDescription = ""
                    )
                }

            }
        }
    }
}

@Composable
fun ProgressViewItem(modifier: Modifier) {
    Card(
        modifier = modifier, shape = RoundedCornerShape(8.dp),
    ) {
        Row(modifier.height(100.dp)) {
            VerticalDivider()
            Column(
                modifier = modifier
                    .padding(vertical = 15.dp, horizontal = 10.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "24.03.2024",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceBright
                    )
                    Text(
                        text = "23.03.2024",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceBright
                    )

                }
                Spacer(modifier = modifier.height(5.dp))
                Divider(
                    modifier = modifier.height(1.dp),
                    color = MaterialTheme.colorScheme.surfaceTint
                )
                Spacer(modifier = modifier.height(5.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "50 min",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceDim
                    )
                    Text(
                        text = "20 min",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceDim
                    )

                }
                Spacer(modifier = modifier.height(5.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Goals",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceDim
                    )
                    Text(
                        text = "1",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.surfaceDim
                    )

                }

            }
        }
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.surfaceBright,
    thickness: Dp = 5.dp
) {
    Box(
        modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color = color)
    )
}

private const val DividerAlpha = 0.12f