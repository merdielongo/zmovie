package com.elongocrea.zmovie.ui.components.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elongocrea.zmovie.ui.theme.SecondaryColor

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    backgroundColor: Color = SecondaryColor,
    labelColor: Color = Color.White,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = labelColor
        ),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(text = label)
    }
}