package com.mashup.alcoholfree.presentation.debug_bridge

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun DebugBridgeScreen(items: List<Class<out Activity>>) {
    val context = LocalContext.current

    LazyColumn {
        items(items.size) { index ->
            Button(
                onClick = { context.startActivity(Intent(context, items[index])) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = items[index].simpleName)
            }
        }
    }
}
