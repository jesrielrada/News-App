package com.prometheus_service.midas.newsapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prometheus_service.midas.newsapp.components.ArticleInfoScreen
import com.prometheus_service.midas.newsapp.components.NewsScreen
import com.prometheus_service.midas.newsapp.ui.theme.NewsAppTheme
import com.prometheus_service.midas.newsapp.util.toLocalDateTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Navigation()
                }
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    private fun Navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "news_screen"
        ) {
            composable(
                route = "news_screen"
            ) {
                NewsScreen(navController = navController)
            }
            composable(
                route = "article_info/{author}/{publishDate}",
                arguments = listOf(
                    navArgument("author") {
                        type = NavType.StringType
                    },
                    navArgument("publishDate") {
                        type = NavType.StringType
                    }
                )
            ) { entry ->
                val argAuthor = entry.arguments?.getString("author")
                val author = if(argAuthor.isNullOrEmpty()) "Author: Unknown" else "Author: $argAuthor"
                val publishDate = "Publish Date: ${entry.arguments?.getString("publishDate")?.toLocalDateTime()}"

                ArticleInfoScreen(
                    navController = navController,
                    author = author,
                    publishDate = publishDate
                )
            }
        }
    }
}

