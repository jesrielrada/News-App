package com.prometheus_service.midas.newsapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prometheus_service.midas.newsapp.data.model.Article
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsItem(
    article: Article,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
    ) {

        GlideImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(bottom = 8.dp),
            imageModel = article.urlToImage
        )

        Text(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = article.title
        )

        Text(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Start),
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            text = article.description
        )
    }
}
