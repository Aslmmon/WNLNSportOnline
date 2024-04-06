package com.winalane.sport.online.ui.workout

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R
import com.winalane.sport.online.ui.components.AppButton
import com.winalane.sport.online.ui.components.ContainerBox
import com.winalane.sport.online.ui.components.ItemsView

@Composable
fun WorkOutScreen(modifier: Modifier) {
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
                    .fillMaxHeight()
                    .padding(vertical = 10.dp, horizontal = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = modifier
                ) {
                    items(listSports) { item ->
                        ItemsView(modifier = modifier, sport = item)
                    }
                }


                Image(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.no_exercise),
                    contentDescription = ""
                )


                AppButton(
                    modifier = modifier.align(Alignment.End),
                    text = stringResource(R.string.add_progress),
                    onClick = {

                    })
            }
        }
    }
}


data class Sport(val icon: Int? = null, val name: String, var isSelected: Boolean = false)