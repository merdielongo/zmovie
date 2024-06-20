package com.elongocrea.zmovie.ui.components.form

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elongocrea.zmovie.ui.theme.PrimaryColor


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        modifier = modifier.border(0.5.dp, Color.Gray.copy(alpha = 0.4f), shape = RoundedCornerShape(8.dp)),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        isError = isError,
        textStyle = TextStyle(color = Color.Black),
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.White,
        )
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    CustomTextField(value = "", onValueChange = {})
}