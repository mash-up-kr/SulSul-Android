package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulDefaultButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey000
import com.mashup.alcoholfree.presentation.ui.theme.Grey700
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2

@Composable
fun InvalidCountDialog(
    onContinueClick: () -> Unit = {},
) {
    Dialog(onDismissRequest = onContinueClick) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Grey000)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 4.dp),
                text = stringResource(R.string.common_dialog_title),
                style = H3,
                color = Grey900,
            )

            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = stringResource(R.string.invalid_count_message),
                style = SubTitle2,
                color = Grey700,
            )

            SulSulDefaultButton(
                modifier = Modifier.fillMaxWidth(),
                content = stringResource(R.string.exit_dialog_keep_label),
                buttonColor = SulSulButtonColor.GREY300,
                buttonSize = SulSulButtonSize.LARGE,
                onClick = onContinueClick,
            )
        }
    }
}

@Preview
@Composable
fun InvalidCountDialogPreview() {
    AlcoholFreeAndroidTheme {
        InvalidCountDialog()
    }
}
