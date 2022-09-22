package com.prometheus_service.midas.newsapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ArticleInfo(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)

    ) {

        Text(
            text = AUTHOR,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = PUBLISHED_AT,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

private const val AUTHOR = "Author: Anders Hagstrom"
private const val PUBLISHED_AT = "Publish At: 2022-09-21T11:37:23Z"

