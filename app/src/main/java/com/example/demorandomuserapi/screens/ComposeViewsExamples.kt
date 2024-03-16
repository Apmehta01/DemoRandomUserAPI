package com.example.demorandomuserapi.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demorandomuserapi.R
import com.example.demorandomuserapi.ui.CustomButton
import com.example.demorandomuserapi.ui.CustomFloatingActionButton
import com.example.demorandomuserapi.ui.CustomIconButton
import com.example.demorandomuserapi.ui.CustomImage
import com.example.demorandomuserapi.ui.CustomOutlineButton
import com.example.demorandomuserapi.ui.CustomText
import com.example.demorandomuserapi.ui.CustomTextButton
import com.example.demorandomuserapi.ui.CustomGradientHorizontalButton
import com.example.demorandomuserapi.ui.CustomGradientVerticalButton
import com.example.demorandomuserapi.ui.CustomIconToggleButton

import com.example.demorandomuserapi.ui.CustomTwoIconButton
import com.example.demorandomuserapi.ui.theme.DemoRandomUserAPITheme
import com.example.demorandomuserapi.ui.theme.Purple500
import com.example.demorandomuserapi.ui.theme.Teal200
import com.example.demorandomuserapi.ui.theme.Typography
import com.example.demorandomuserapi.ui.theme.boldFont
import com.example.demorandomuserapi.ui.theme.extraBoldFont
import com.example.demorandomuserapi.ui.theme.normalFont
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeViewsExamples :ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoRandomUserAPITheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "Weather App")
                    }, backgroundColor = Purple500, contentColor = Color.White)
                }) {
                    Box(modifier = Modifier
                        .padding(it)
                        .fillMaxHeight()
                        .background(Color.White)) {
                        showComposeViews()
                    }
                }
            }
        }
    }

    @Composable
    private fun showComposeViews() {
        var checked by remember { mutableStateOf(false) }

        Column(  modifier = Modifier .verticalScroll(rememberScrollState())
            .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {

            CustomText(text = "Arpan" ,
                style = TextStyle(
                    fontFamily = normalFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                ),
                textAlign = TextAlign.Start, color = Purple500)
            CustomImage(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                cornerRadius = 8,
                width = 0,
                height = 200,
            )
            CustomButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                modifier = Modifier.padding(8.dp), // Optional: Add padding to the button
                shape = RoundedCornerShape(8.dp), // Optional: Customize the button shape
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ), // Optional: Customize the text style
                textColor = Color.White,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                borderColor = Color.Transparent,
                buttonColor = Teal200, // Optional: Customize the button color


            )
            CustomTextButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                textColor = Purple500,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle =  TextStyle(
                    fontFamily = extraBoldFont,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                ),

                )
            CustomOutlineButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                textColor = Purple500,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                borderColor = Purple500,
                borderWidth = 2.dp,
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
            )

            CustomButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                textColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape =RoundedCornerShape(15.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 15.dp),
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
                borderColor = Color.Transparent,
                buttonColor = Teal200, // Optional: Customize the button color
            )
            CustomButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                textColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = CutCornerShape(15.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 15.dp),
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ),
                borderColor = Color.Transparent,
                buttonColor = Teal200, // Optional: Customize the button color
            )
            CustomIconButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                modifier = Modifier.padding(8.dp), // Optional: Add padding to the button
                shape = RoundedCornerShape(8.dp), // Optional: Customize the button shape
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ), // Optional: Customize the text style
                buttonColor = Teal200,
                borderColor = Color.Transparent,// Optional: Customize the button color
                textColor = Color.White,
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                imagePath = Icons.Default.FavoriteBorder, // Set the icon image vector
                iconColor = Color.White
            )
            CustomTwoIconButton(
                text = "Click Me",
                onClick = { /* Handle button click */ },
                modifier = Modifier.padding(8.dp), // Optional: Add padding to the button
                shape = RoundedCornerShape(8.dp), // Optional: Customize the button shape
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ), // Optional: Customize the text style
                buttonColor = Teal200,
                borderColor = Color.Transparent,// Optional: Customize the button color
                textColor = Color.White,
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                imagePath = Icons.Default.FavoriteBorder, // Set the icon image vector
                iconColor = Color.White
            )

            CustomGradientHorizontalButton(
                text = "Click Me",
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ), // Optional: Customize the text style,
                textColor = Color.White,
                modifier = Modifier.padding(5.dp),
                horizontalGradientBrush = Brush.horizontalGradient(
                    colors = listOf(Color.Blue, Color.Green)
                ),
                width = 200.dp,
                paddingValues = PaddingValues(horizontal = 0.dp, vertical = 0.dp), // Adjust padding
                textAlign = TextAlign.Center, // Adjust text alignment
                onClick = { /* Handle button click */ }
            )

            CustomGradientVerticalButton(
                text = "Click Me",
                textStyle =  TextStyle(
                    fontFamily = boldFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                ), // Optional: Customize the text style,
                textColor = Color.White,
                modifier = Modifier.padding(5.dp),
                verticalGradientBrush = Brush.verticalGradient(
                    colors = listOf(Color.Blue, Color.Green)
                ),
                width = 200.dp,
                paddingValues = PaddingValues(horizontal = 0.dp, vertical = 0.dp), // Adjust padding
                textAlign = TextAlign.Center, // Adjust text alignment
                onClick = { /* Handle button click */ }
            )

            CustomIconToggleButton(
                checked = checked,
                onCheckedChange = { checked = it },
                checkedIcon = Icons.Default.Favorite,
                uncheckedIcon = Icons.Default.FavoriteBorder,
                checkedTint = Teal200,
                uncheckedTint = Color.Gray,
                contentDescription = "Favorite Icon",
                iconColor = Color.Transparent,
                onClick = { /* Handle button click */ }
            )
        }

        CustomFloatingActionButton(
            onClick = { /* Handle FAB click */ },
            modifier = Modifier.padding(10.dp),
            iconColor = Color.White,
            imagePath = Icons.Default.Favorite,
        )

        CustomImage(
            painter = painterResource(id = R.drawable.ic_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            cornerRadius = 8,
            width = 0,
            height = 200,
        )
    }
}