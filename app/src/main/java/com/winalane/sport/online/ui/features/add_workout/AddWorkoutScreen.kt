package com.winalane.sport.online.ui.features.add_workout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R
import com.winalane.sport.online.data.Sport
import com.winalane.sport.online.ui.common.SharedViewModel
import com.winalane.sport.online.ui.common.getcurrentDate
import com.winalane.sport.online.ui.features.components.AddProgressInputs
import com.winalane.sport.online.ui.features.components.AppButton
import com.winalane.sport.online.ui.features.components.ContainerBox
import com.winalane.sport.online.ui.features.components.WorkoutIconWithTitle

@Composable
fun AddWorkOutScreen(
    modifier: Modifier,
    onNavigateBack: () -> Unit,
    sharedViewModel: SharedViewModel<Sport>,
    addWorkoutViewModel: AddWorkOutViewModel
) {
    val sportChoosen = sharedViewModel.data.value

    val uiState by addWorkoutViewModel.sportsData.collectAsState()

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {


        ContainerBox(modifier = modifier) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp, horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(16.dp))
                        .height(35.dp)
                        .background(MaterialTheme.colorScheme.secondary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = modifier.padding(horizontal = 45.dp, vertical = 5.dp),
                        text = context.getcurrentDate(),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
                WorkoutIconWithTitle(modifier, sportChoosen)
                AddProgressInputs(
                    modifier,
                    sportChoosen,
                    onDistanceInput = {
                        addWorkoutViewModel.updateDistance(it)
                    },
                    onAmountInput = {
                        addWorkoutViewModel.updateAmount(it)
                    },
                    onDurationInput = {
                        addWorkoutViewModel.updateDuration(it)
                    })
                AppButton(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = stringResource(R.string.add_new_progression_title)
                ) {
                    addWorkoutViewModel.updateDate(context.getcurrentDate())
                    Log.e("data", "${uiState.size} $uiState")
                }

                Text(
                    modifier = modifier.clickable {
                        onNavigateBack.invoke()
                    },
                    text = stringResource(R.string.cancel_title),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StyledTextField(modifier: Modifier, titleAfterText: String, onValueChanged: (String) -> Unit) {
    var value by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = modifier
                .width(70.dp), contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = value,
                onValueChange = {
                    value = it
                    onValueChanged.invoke(value)
                },
                modifier = Modifier.height(36.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            ) { innerTextField ->
                TextFieldDefaults.OutlinedTextFieldDecorationBox(
                    value = value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Transparent,
                        cursorColor = Color.Transparent
                    ), innerTextField = innerTextField,
                    singleLine = true,
                    enabled = false,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        top = 0.dp,
                        bottom = 0.dp,

                        )
                )
            }
        }
        Text(
            text = titleAfterText,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.surfaceDim
        )
    }
}