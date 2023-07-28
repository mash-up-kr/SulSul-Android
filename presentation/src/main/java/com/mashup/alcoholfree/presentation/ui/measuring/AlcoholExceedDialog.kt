package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.Grey000
import com.mashup.alcoholfree.presentation.ui.theme.Grey100
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey700
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun AlcoholExceedDialog() {
    var dialogVisible by remember { mutableStateOf(true) }

    if (dialogVisible) {
        Dialog(onDismissRequest = { dialogVisible = false }) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Grey000),

            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp, bottom = 4.dp),
                    text = stringResource(R.string.exceed_my_alcohol),
                    style = H3,
                    color = Grey900,
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(R.string.exceed_my_alcohol_intro_label),
                    style = SubTitle2,
                    color = Grey700,
                )

                MissionContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                )

                ConfirmButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    onConfirmClick = { dialogVisible = false },
                )
            }
        }
    }
}

@Composable
private fun MissionContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Grey100)
            .padding(vertical = 16.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.mission_label),
            style = SubTitle4,
            color = Grey700,
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.mission_content),
            style = SubTitle2,
            color = Grey900,
        )
    }
}

@Composable
private fun ConfirmButton(
    modifier: Modifier = Modifier,
    onConfirmClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Grey300)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = { onConfirmClick() },
            ),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 17.dp),
            text = stringResource(R.string.alert_btn_text),
            style = SubTitle2,
            color = White,
        )
    }
}

@Preview
@Composable
private fun AlcoholAlertPreview() {
    AlcoholExceedDialog()
}
