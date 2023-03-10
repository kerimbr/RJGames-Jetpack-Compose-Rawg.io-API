package com.example.rjgames.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.rjgames.R
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String,
    contentScale: ContentScale? = ContentScale.Crop,
) {

    GlideImage(
        modifier = modifier,
        imageModel = { url } ,
        requestOptions = {
            RequestOptions().diskCacheStrategy(
                DiskCacheStrategy.AUTOMATIC
            )
        },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            requestSize = IntSize(800,600)
        ),
        previewPlaceholder = R.drawable.ic_launcher_background,
        loading = {
            Box(
                modifier = modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
        },
        success = { imageState ->
            imageState.imageBitmap?.let {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    bitmap = it,
                    contentDescription = contentDescription,
                    contentScale = contentScale ?: ContentScale.Crop
                )
            }
        },
    )
}