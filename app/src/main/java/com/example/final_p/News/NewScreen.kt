package com.example.final_p.News

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.final_p.DataModel

@Composable
fun newsScreen(
    dataModel: DataModel
){
    Text(text = "NewsScreen ${dataModel.country()}")
}