package com.example.final_p.News

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.final_p.Concode
import com.example.final_p.DataModel

@Composable
fun newsScreen(
    dataModel: DataModel
){
    val datain =dataModel.country()
    when(datain){
        Concode.Error -> TODO()
        Concode.Loading -> {
            Text(text = "Loading")
        }
        is Concode.Success -> {Text(text = "NewsScreen ${dataModel.country()}")}
    }

}