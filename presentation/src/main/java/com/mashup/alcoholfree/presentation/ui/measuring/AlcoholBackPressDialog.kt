package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulDefaultButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.Grey000
import com.mashup.alcoholfree.presentation.ui.theme.Grey700
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2

@Composable
fun AlcoholBackPressDialog(
    onContinueClick: () -> Unit,
    onExitClick: () -> Unit,
) {
    Dialog(onDismissRequest = onContinueClick) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Grey000)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.back_press_exit_label),
                style = H3,
                color = Grey900,
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(R.string.back_press_dialog_content),
                style = SubTitle2,
                color = Grey700,
                textAlign = TextAlign.Center,
            )

            DialogButtonGroup(
                modifier = Modifier.padding(top = 16.dp),
                onContinueClick = onContinueClick,
                onExitClick = onExitClick,
            )
        }
    }
}

@Composable
private fun DialogButtonGroup(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit,
    onExitClick: () -> Unit,
) {
    Row(
        modifier = modifier,
    ) {
        SulSulDefaultButton(
            modifier = Modifier.weight(1f),
            content = stringResource(R.string.exit_dialog_keep_label),
            buttonColor = SulSulButtonColor.GREY300,
            buttonSize = SulSulButtonSize.LARGE,
            onClick = onContinueClick,
        )

        Spacer(modifier = Modifier.width(8.dp))

        SulSulDefaultButton(
            modifier = Modifier.weight(1f),
            content = stringResource(R.string.exit_dialog_finish_label),
            buttonColor = SulSulButtonColor.PRIMARY100,
            buttonSize = SulSulButtonSize.LARGE,
            onClick = onExitClick,
        )
    }
}

@Preview
@Composable
private fun AlcoholBackPressDialogPreview() {
    AlcoholBackPressDialog(
        onExitClick = {},
        onContinueClick = {},
    )
}
