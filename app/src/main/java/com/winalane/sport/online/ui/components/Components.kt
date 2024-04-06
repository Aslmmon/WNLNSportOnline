package com.winalane.sport.online.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.winalane.sport.online.R
import com.winalane.sport.online.ui.add_workout.StyledTextField
import com.winalane.sport.online.ui.workout.Sport


@Composable
fun AppButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .height(40.dp)
            .clickable {
                onClick.invoke()
            }
            .background(color = MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            color = Color.White,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,

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

@Composable
fun MinimalDialog(modifier: Modifier, newScoreImage: Int, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 40.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier.padding(vertical = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.new_level),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium
                )


                Box(modifier = modifier, contentAlignment = Alignment.TopCenter) {
                    Divider(
                        modifier = modifier.height(50.dp),
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = newScoreImage),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = modifier
                                .padding(top = 15.dp)
                                .size(100.dp, 120.dp)

                        )
                        Text(
                            text = "confidence",
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .wrapContentSize(Alignment.Center),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                AppButton(modifier = modifier, text = "Thanks") {
                    onDismissRequest.invoke()
                }
            }
        }
    }
}

@Composable
fun AddProgressInputs(modifier: Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = modifier
                .padding(vertical = 15.dp, horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {


            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Duration",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.surfaceDim
                )
                StyledTextField(modifier, " Km")


            }
            Spacer(modifier = modifier.height(15.dp))
            Divider(
                modifier = modifier.height(1.dp),
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Spacer(modifier = modifier.height(15.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Distance",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.surfaceDim
                )
                StyledTextField(modifier, " min")


            }

        }
    }
}

@Composable
fun WorkoutIconWithTitle(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.bicycle),
            contentDescription = "",
            Modifier.size(75.dp)
        )
        Text(
            modifier = modifier.padding(horizontal = 45.dp, vertical = 5.dp),
            text = "Bicycle",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }

}