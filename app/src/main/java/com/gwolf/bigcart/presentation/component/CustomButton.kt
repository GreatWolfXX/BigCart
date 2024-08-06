package com.gwolf.bigcart.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gwolf.bigcart.R
import com.gwolf.bigcart.ui.theme.ButtonGradient
import com.gwolf.bigcart.ui.theme.PrimaryTextColor
import com.gwolf.bigcart.ui.theme.poppinsFontFamily

enum class CustomButtonStyle{
    STANDARD,
    GOOGLE
}

@Composable
fun CustomButton(
    @DrawableRes icon: Int = 0,
    @StringRes text: Int,
    style: CustomButtonStyle = CustomButtonStyle.STANDARD,
    onClick: () -> Unit
) {
    val isStandardStyle = style == CustomButtonStyle.STANDARD
    val btnIcon = if(isStandardStyle) {
        ImageVector.vectorResource(id = icon)
    } else {
        ImageVector.vectorResource(id = R.drawable.google_ic)
    }
    val bgColor = if(isStandardStyle) Color.Transparent else Color.White
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = ButtonGradient,
                shape = RoundedCornerShape(5.dp)
            ),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        ),
        contentPadding = PaddingValues(16.dp),
        onClick = { onClick.invoke() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = btnIcon,
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = text),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = if(isStandardStyle) Color.White else PrimaryTextColor
            )
            Spacer(modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        icon = R.drawable.account_ic,
        text = R.string.create_account_title,
        style = CustomButtonStyle.GOOGLE
    ) { }
}