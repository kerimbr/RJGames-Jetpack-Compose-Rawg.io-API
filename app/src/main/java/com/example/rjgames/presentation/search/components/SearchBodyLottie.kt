package com.example.rjgames.presentation.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.rjgames.R
import com.example.rjgames.presentation.ui.theme.AppTheme

@Composable
fun SearchBodyLottie(
    modifier: Modifier = Modifier
) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.search_lottie)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .align(alignment = Alignment.CenterHorizontally),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

        Text(
            modifier = Modifier.padding(16.dp),
            text = buildAnnotatedString {
                append("Search for ")

                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                    )
                ) {
                    append("Games")
                }
            },
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
        )


    }
}

@Preview(name = "SearchBodyLottie", showBackground = true)
@Composable
private fun PreviewSearchBodyLottie() {
    AppTheme {
        SearchBodyLottie()
    }
}