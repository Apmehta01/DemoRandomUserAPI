package com.example.demorandomuserapi.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.demorandomuserapi.R
import com.example.demorandomuserapi.model.RandomUserData
import com.example.demorandomuserapi.model.Result
import com.example.demorandomuserapi.ui.CustomImage
import com.example.demorandomuserapi.ui.CustomText
import com.example.demorandomuserapi.ui.theme.DemoRandomUserAPITheme
import com.example.demorandomuserapi.ui.theme.Purple500
import com.example.demorandomuserapi.ui.theme.Typography
import com.example.demorandomuserapi.ui.theme.boldFont
import com.example.demorandomuserapi.ui.theme.normalFont
import com.example.demorandomuserapi.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoRandomUserAPITheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "Random User Data")
                    }, backgroundColor = Purple500, contentColor = Color.White)
                }) {
                    Box(modifier = Modifier.padding(it).background(Color.White)){
                        // Provide ViewModel
                        val viewModel: RandomUserViewModel = hiltViewModel()
                        callAPI(viewModel)
                        val randomUserData: State<RandomUserData?> = viewModel.randomUserData.collectAsState()

                        ShowRandomUserData(randomUserData)
                    }
                }
        }
    }
}

    @Composable
    private fun ShowRandomUserData(randomUserData: State<RandomUserData?>) {

        if(randomUserData.value == null || randomUserData.value?.results.isNullOrEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(1f),
                contentAlignment = Alignment.Center
            ) {
                CustomText(text = "Loading......." ,
                    style = TextStyle(
                        fontFamily = normalFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    ),
                    textAlign = TextAlign.Center, color = Purple500)
            }
        }else if(randomUserData.value?.results!=null&& randomUserData.value!!.results.size>0){
            val length= randomUserData.value?.results?.size
            println("LENGTH:>>>>>>> ${length}")
            LazyColumn {
                items(randomUserData.value!!.results) { result ->
                    UserListItem(result = result)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

    @Composable
    fun UserListItem(result: Result) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                CustomImage(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                    cornerRadius = 8,
                    width = 0,
                    height = 64,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    CustomText(  text = "${result.name.title}. ${result.name.first} ${result.name.last}",
                        style = TextStyle(
                            fontFamily = boldFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        ),
                        textAlign = TextAlign.Start, color = Color.White)

                    Spacer(modifier = Modifier.height(8.dp))

                    CustomText(  text =result.email,
                        style = TextStyle(
                            fontFamily = normalFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                        ),
                        textAlign = TextAlign.Start, color = Color.White)
                }
            }
        }
    }

    private fun callAPI(viewModel: RandomUserViewModel) {
        viewModel.viewModelScope.launch {
            viewModel.getRandomUserData(7)
        }
    }
}