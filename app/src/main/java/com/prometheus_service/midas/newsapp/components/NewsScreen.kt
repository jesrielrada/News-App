package com.prometheus_service.midas.newsapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prometheus_service.midas.newsapp.MainViewModel


@Preview
@Composable
fun NewsScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 12.dp, start = 16.dp),
            text = "Today's Headlines",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn {
            state.newsArticles?.let {
                items(it) { article ->
                    NewsItem(
                        article = article,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {

                            })

                }
            }

        }
    }


}