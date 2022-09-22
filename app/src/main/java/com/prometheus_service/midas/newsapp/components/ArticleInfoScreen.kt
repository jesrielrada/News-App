package com.prometheus_service.midas.newsapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArticleInfoScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    author: String,
    publishDate: String
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigateUp() },
                backgroundColor = Color.Gray
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }, scaffoldState = rememberScaffoldState()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xffFAF9F6))
                .padding(16.dp)

        ) {
            ArticleInfo(author = author, publishDate = publishDate)
        }
    }

}