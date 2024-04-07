package com.winalane.sport.online.ui.workout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R
import com.winalane.sport.online.data.sportList
import com.winalane.sport.online.ui.components.AppButton
import com.winalane.sport.online.ui.components.ContainerBox
import com.winalane.sport.online.ui.components.ItemsView

@Composable
fun WorkOutScreen(modifier: Modifier, onNavigateToAddWorkOut: () -> Unit) {

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
                    items(sportList) { item ->
                        ItemsView(modifier = modifier, sport = item)
                    }
                }
                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(2) {
                        WorkOutViewItem(modifier = modifier)
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
                        onNavigateToAddWorkOut.invoke()
                    })
            }
        }
    }
}


data class Sport(val icon: Int? = null, val name: String, var isSelected: Boolean = false)


@Composable
fun WorkOutViewItem(modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 15.dp, horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "24.03.2024", style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = modifier.height(5.dp))
            Divider(modifier = modifier.height(1.dp), color = MaterialTheme.colorScheme.surfaceTint)
            Spacer(modifier = modifier.height(5.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Duration",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.surfaceDim
                )
                Text(
                    text = "120 min",
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