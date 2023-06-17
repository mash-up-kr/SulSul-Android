package com.mashup.alcoholfree.presentation.measuring

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey100
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

private val selectionShape = RoundedCornerShape(16.dp)

@Composable
fun AlcoholSelection(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedIndex: Int,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(selectionShape)
            .background(color = Grey100)
            .border(width = 1.dp, color = Grey300, shape = selectionShape),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.alcohol_type_selection),
            style = SubTitle3,
            color = Grey800,
        )
        AlcoholSelectionRow(
            modifier = Modifier
                .padding(horizontal = 34.dp)
                .padding(bottom = 12.dp),
            items = items,
            selectedIndex = selectedIndex,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick,
        )
    }
}

@Composable
private fun AlcoholSelectionRow(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedIndex: Int,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
) {
    Box(
        modifier = modifier,
    ) {
        AlcoholSelectionPager(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .align(Alignment.Center),
            items = items,
            selectedPage = selectedIndex
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        0.15f to Grey100,
                        0.5f to Color.Transparent,
                        0.85f to Grey100,
                    ),
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = onLeftClick,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_doublechevron_left),
                    contentDescription = null,
                    tint = White,
                )
            }
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = onRightClick,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_doublechevron_right),
                    contentDescription = null,
                    tint = White,
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AlcoholSelectionPager(
    modifier: Modifier = Modifier,
    items: List<String>,
    selectedPage: Int,
) {
    val pagerState = rememberPagerState()

    LaunchedEffect(selectedPage) {
        pagerState.animateScrollToPage(selectedPage)
    }

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageCount = items.size,
        contentPadding = PaddingValues(horizontal = 80.dp),
        userScrollEnabled = false,
    ) { page ->
        Text(
            modifier = Modifier.width(72.dp),
            text = items[page],
            style = H2,
            color = White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun AlcoholSelectionPreview() {
    AlcoholFreeAndroidTheme {
        var page by remember { mutableStateOf(0) }

        AlcoholSelection(
            items = listOf(
                "소주", "맥주", "와인", "위스키", "고량주",
            ),
            selectedIndex = page,
            onLeftClick = { page -= 1 },
            onRightClick = { page += 1 },
        )
    }
}
