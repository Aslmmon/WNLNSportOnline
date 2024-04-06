package com.winalane.sport.online.ui.progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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