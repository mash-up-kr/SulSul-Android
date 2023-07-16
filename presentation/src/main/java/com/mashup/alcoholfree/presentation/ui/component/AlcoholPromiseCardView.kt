package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.mashup.alcoholfree.presentation.ui.component.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.component.model.AlcoholPromiseCardType
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlcoholPromiseCardView(
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = 5,
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 40.dp),
    ) { page ->
        AlcoholPromiseCard(
            modifier = Modifier.graphicsLayer {
                val pageOffset = (
                    (pagerState.currentPage - page) + pagerState
                        .currentPageOffsetFraction
                    ).absoluteValue

                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }

                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                )
            },
            list = listOf(
                AlcoholPromiseCardState("맥주", 1),
                AlcoholPromiseCardState("소주", 2),
            ),
            alcohol = AlcoholPromiseCardType.BEER,
            badgeTitle = "술좀치네",
            date = "2021.08.01",
        )
    }
}
