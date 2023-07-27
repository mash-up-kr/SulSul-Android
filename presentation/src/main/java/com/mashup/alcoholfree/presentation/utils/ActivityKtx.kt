package com.mashup.alcoholfree.presentation.utils

import android.app.Activity
import android.content.Intent

fun Activity.moveToActivity(activity: Class<*>) {
    startActivity(
        Intent(this, activity),
    )
}
