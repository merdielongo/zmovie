package com.elongocrea.zmovie.ui.components.button

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.elongocrea.zmovie.R
import com.elongocrea.zmovie.ui.theme.PrimaryColor

@Composable
fun ButtonIcon(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    color: ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.White),
    label: String,
    labelColor: Color = Color.Black,
    icon: Painter = painterResource(id = R.drawable.ic_google),
    iconModifier: Modifier = Modifier.size(30.dp),
    onClick: () -> Unit,
) {
    Button(
        shape = shape,
        onClick = onClick,
        modifier = modifier,
        colors = color
    ) {
        Icon(
            modifier = iconModifier,
            painter = icon,
            contentDescription = null,
            tint = PrimaryColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = labelColor)
    }
}