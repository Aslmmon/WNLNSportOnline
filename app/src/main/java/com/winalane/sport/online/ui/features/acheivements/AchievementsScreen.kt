package com.winalane.sport.online.ui.features.acheivements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.winalane.sport.online.R
import com.winalane.sport.online.ui.features.components.MinimalDialog

@Composable
fun AchievmentsScreen(modifier: Modifier) {
    var listSports = mutableListOf<AchivementsData>(
        AchivementsData(R.drawable.lvl_1_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_2_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_3_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_4_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_5_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_6_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_7_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_8_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_9_unachieved, R.drawable.lvl_1_achieved),
        AchivementsData(R.drawable.lvl_10_unachieved, R.drawable.lvl_1_achieved),

        )

    val openAlertDialog = remember { mutableStateOf(true) }
    when {
        openAlertDialog.value -> {
            MinimalDialog(
                modifier = modifier,
                newScoreImage = R.drawable.lvl_1_achieved,
                onDismissRequest = { openAlertDialog.value = false },
            )
        }
    }


    Column(

        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary),
    ) {
        Image(
            painter = painterResource(id = R.drawable.level_track),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .size(80.dp)
        )
        Spacer(modifier = modifier.height(10.dp))
        LazyVerticalGrid(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .wrapContentHeight(),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(10.dp),

            ) {
            itemsIndexed(listSports) { index, photo ->
                Image(
                    painter = painterResource(id = photo.unachievedIcon),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                )

            }
        }
//        Image(
//            modifier = modifier
//                .size(100.dp)
//                .align(Alignment.CenterHorizontally),
//            painter = painterResource(id = listSports[listSports.lastIndex].unachievedIcon),
//            contentDescription = "",
//            contentScale = ContentScale.Crop,
//        )
    }

}

data class AchivementsData(
    var unachievedIcon: Int,
    var achievedIcon: Int
)