package com.winalane.sport.online.ui.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.winalane.sport.online.R
import com.winalane.sport.online.data.SPORTY
import com.winalane.sport.online.data.Sport
import com.winalane.sport.online.ui.features.add_workout.StyledTextField


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
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        content.invoke()
    }
}

@Composable
fun ItemsView(
    modifier: Modifier,
    sport: Sport,
    onItemClicked: (Sport) -> Unit,
) {


//    val checkedSport by remember {
//        mutableStateOf(initialChecked)
//    }
//    var isChecked by remember {
//        mutableStateOf(isItemChecked)
//    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(
                color =
                if (sport.selected) MaterialTheme.colorScheme.secondary else Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.clickable {
//            isChecked = checkedSport== sport
//            isChecked = true
            onItemClicked.invoke(sport)
            // isChecked = sport.isSelected

        }) {
            Icon(
                modifier = modifier.padding(start = 5.dp),
                imageVector = ImageVector.vectorResource(id = sport.icon),
                contentDescription = "Some icon",
                tint = if (sport.selected) Color.White else MaterialTheme.colorScheme.secondary
            )
            Text(
                text = sport.name,
                modifier = modifier.padding(10.dp),
                color = if (sport.selected) Color.White else MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium,
            )
        }
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
fun AddProgressInputs(
    modifier: Modifier,
    sportChosen: Sport?,
    onDurationInput: (String) -> Unit,
    onDistanceInput: (String) -> Unit,
    onAmountInput: (String) -> Unit,

    ) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(150.dp),
        shape = RoundedCornerShape(8.dp),
    ) {

        when (sportChosen?.sporty) {
            SPORTY.TWOEDITTEXT -> {
                Column(
                    modifier = modifier.padding(vertical = 15.dp, horizontal = 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween

                ) {

                    EditTextWithTitle(
                        modifier = modifier,
                        title = "Duration",
                        placeholder = "Km",
                        onValueChanged = { text ->
                            onDurationInput.invoke(text)
                        })
                    DividerView(modifier = modifier)
                    EditTextWithTitle(
                        modifier = modifier,
                        title = "Distance",
                        placeholder = "min",
                        onValueChanged = { distance ->
                            onDistanceInput.invoke(distance)
                        })

                }
            }

            SPORTY.ONEEDITTEXT -> {
                Column(
                    modifier = modifier.padding(vertical = 15.dp, horizontal = 10.dp),
                    horizontalAlignment = Alignment.Start

                ) {
                    EditTextWithTitle(
                        modifier = modifier,
                        title = "Amount",
                        onValueChanged = { amount ->
                            onAmountInput.invoke(amount)
                        })
                    DividerView(modifier = modifier)
                }
            }

            SPORTY.SPINNERANDEDITTEXT -> {
                Column(
                    modifier = modifier.padding(vertical = 15.dp, horizontal = 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "spinner is here ")
                    DividerView(modifier = modifier)
                    EditTextWithTitle(
                        modifier = modifier,
                        title = "Amount",
                        onValueChanged = { amount ->
                            onAmountInput.invoke(amount)
                        })
                }
            }

            else -> {

            }
        }

    }
}

@Composable
fun EditTextWithTitle(
    modifier: Modifier,
    title: String,
    placeholder: String? = null,
    onValueChanged: (String) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.surfaceDim
        )
        StyledTextField(modifier, " $placeholder", onValueChanged)


    }
}

@Composable
fun DividerView(modifier: Modifier) {
    Spacer(modifier = modifier.height(5.dp))
    Divider(
        modifier = modifier.height(1.dp),
        color = MaterialTheme.colorScheme.surfaceTint
    )
    Spacer(modifier = modifier.height(5.dp))
}

@Composable
fun WorkoutIconWithTitle(modifier: Modifier, sportChoosen: Sport?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = sportChoosen?.categoryType?.image ?: R.drawable.bicycle),
            contentDescription = "",
            Modifier.size(75.dp)
        )
        Text(
            modifier = modifier.padding(horizontal = 45.dp, vertical = 5.dp),
            text = sportChoosen?.name ?: "",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }

}