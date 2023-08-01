package com.mashup.alcoholfree.presentation.ui.component

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.Grey600
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle1

@Composable
fun SulSulLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.FillBounds,
            ),
    ) {
        val imageLoader = ImageLoader
            .Builder(LocalContext.current)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        LoadingContent(
            modifier = Modifier.align(Alignment.Center),
            imageLoader = imageLoader,
        )
    }
}

@Composable
private fun LoadingContent(
    modifier: Modifier = Modifier,
    imageLoader: ImageLoader,
) {
    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = R.drawable.sulsul_loading)
                    .apply(
                        block = fun ImageRequest.Builder.() {
                            size(Size.ORIGINAL)
                        },
                    )
                    .build(),
                imageLoader = imageLoader,
            ),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )

        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(R.string.loading_title_label),
            style = H2,
            color = Grey900,
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = stringResource(R.string.loading_sub_title_label),
            style = SubTitle1,
            color = Grey600,
        )
    }
}

@Preview
@Composable
private fun SulSulLoadingPreview() {
    SulSulLoading()
}
