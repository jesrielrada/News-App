package com.prometheus_service.midas.newsapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prometheus_service.midas.newsapp.R
import com.prometheus_service.midas.newsapp.data.model.Article
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsItem(
    article: Article,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .clip(RoundedCornerShape(38.dp))
            .padding(8.dp)
    ) {
        GlideImage(
            modifier = Modifier
                .clip(RoundedCornerShape(38.dp))
                .fillMaxWidth()
                .height(180.dp)
                .padding(8.dp),
            imageModel = article.urlToImage
        )

        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Start),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = article.title
        )

        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Start),
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            text = article.description
        )
    }
}
