package com.gwolf.bigcart.presentation.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gwolf.bigcart.R
import com.gwolf.bigcart.presentation.component.CustomButton
import com.gwolf.bigcart.presentation.component.CustomButtonStyle
import com.gwolf.bigcart.ui.theme.BackgroundColor
import com.gwolf.bigcart.ui.theme.PrimaryTextColor
import com.gwolf.bigcart.ui.theme.SecondaryTextColor
import com.gwolf.bigcart.ui.theme.poppinsFontFamily

@Composable
fun WelcomeScreen() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = BackgroundColor,
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    )
                .padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 40.dp)
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.welcome_title),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                color = PrimaryTextColor
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.welcome_desc),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = SecondaryTextColor
            )
            Spacer(modifier = Modifier.size(28.dp))
            CustomButton(
                text = R.string.continue_google_title,
                style = CustomButtonStyle.GOOGLE)
            {

            }
            Spacer(modifier = Modifier.size(12.dp))
            CustomButton(
                icon = R.drawable.account_ic,
                text = R.string.create_account_title)
            {

            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.already_have),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = SecondaryTextColor
                )
                Text(
                    modifier = Modifier,
                    text = stringResource(id = R.string.login),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = PrimaryTextColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}