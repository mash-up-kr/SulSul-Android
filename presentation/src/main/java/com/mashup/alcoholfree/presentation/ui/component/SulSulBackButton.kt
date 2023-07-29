package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey900

@Composable
fun SulSulBackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier.size(40.dp),
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = Grey900,
        )
    }
}

@Preview
@Composable
fun SulSulBackButtonPreview() {
    AlcoholFreeAndroidTheme {
        SulSulBackButton(onClick = {})
    }
}
