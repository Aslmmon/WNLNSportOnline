package com.winalane.sport.online.ui.workout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R

@Composable
fun WorkOutScreen(modifier: Modifier) {
    var listSports = mutableListOf<Sport>(
        Sport(name = "Football", isSelected = true),
        Sport(name = "Football"),
        Sport(name = "Football"),
        Sport(name = "Football"),
        Sport(name = "Football"),
        Sport(name = "Football")
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {


        Box(
            modifier = modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp))
                .padding(horizontal = 5.dp, vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                ) {
                    items(listSports) { item ->
                        Box(
                            modifier = modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(color = if (item.isSelected) MaterialTheme.colorScheme.secondary else Color.White)
                        ) {
                            Text(
                                text = item.name,
                                modifier = modifier.padding(10.dp),
                                color = if (item.isSelected) Color.White else MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }


                Image(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.no_exercise),
                    contentDescription = ""
                )

                Button(modifier = modifier.align(Alignment.End), onClick = { /*TODO*/ }) {
                    Text(text = "click me")
                }
            }
        }
    }
}


data class Sport(val icon: Int? = null, val name: String, var isSelected: Boolean = false)