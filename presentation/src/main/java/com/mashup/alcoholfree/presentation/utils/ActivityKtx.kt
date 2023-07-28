package com.mashup.alcoholfree.presentation.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle

fun Activity.moveToActivity(
    activity: Class<*>,
    bundleOf: Bundle? = null,
) {
    startActivity(
        Intent(this, activity).apply {
            bundleOf?.let { putExtras(it) }
        },
    )
}
