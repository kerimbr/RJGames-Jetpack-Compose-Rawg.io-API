package com.example.rjgames.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.rjgames.R

// Set of Material typography styles to start with

val montserratFontFamily: FontFamily = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thin_italic, FontWeight.Thin, style = FontStyle.Italic),

    Font(R.font.montserrat_extra_light, FontWeight.ExtraLight),
    Font(R.font.montserrat_extra_light_italic, FontWeight.ExtraLight, style = FontStyle.Italic),

    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_light_italic, FontWeight.Light, style = FontStyle.Italic),

    Font(R.font.montserrat_regular, FontWeight.Normal),

    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_medium_italic, FontWeight.Medium, style = FontStyle.Italic),

    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.montserrat_semi_bold_italic, FontWeight.SemiBold, style = FontStyle.Italic),

    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_bold_italic, FontWeight.Bold, style = FontStyle.Italic),

    Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extra_bold_italic, FontWeight.ExtraBold, style = FontStyle.Italic),

    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_black_italic, FontWeight.Black, style = FontStyle.Italic),

)

val AppTypography = Typography(

    displayLarge = Typography().displayLarge.copy(
        fontFamily = montserratFontFamily,
    ),

    displayMedium = Typography().displayMedium.copy(
        fontFamily = montserratFontFamily,
    ),

    displaySmall = Typography().displaySmall.copy(
        fontFamily = montserratFontFamily,
    ),

    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = montserratFontFamily,
    ),

    headlineMedium = Typography().headlineMedium.copy(
        fontFamily = montserratFontFamily,
    ),

    headlineSmall = Typography().headlineSmall.copy(
        fontFamily = montserratFontFamily,
    ),

    titleLarge = Typography().titleLarge.copy(
        fontFamily = montserratFontFamily,
    ),

    titleMedium = Typography().titleMedium.copy(
        fontFamily = montserratFontFamily,
    ),

    titleSmall = Typography().titleSmall.copy(
        fontFamily = montserratFontFamily,
    ),

    labelLarge = Typography().labelLarge.copy(
        fontFamily = montserratFontFamily,
    ),

    labelMedium = Typography().labelMedium.copy(
        fontFamily = montserratFontFamily,
    ),

    labelSmall = Typography().labelSmall.copy(
        fontFamily = montserratFontFamily,
    ),

    bodyLarge = Typography().bodyLarge.copy(
        fontFamily = montserratFontFamily,
    ),

    bodyMedium = Typography().bodyMedium.copy(
        fontFamily = montserratFontFamily,
    ),

    bodySmall = Typography().bodySmall.copy(
        fontFamily = montserratFontFamily,
    ),



)