package com.gwolf.bigcart.presentation.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gwolf.bigcart.R
import com.gwolf.bigcart.presentation.component.CustomButton
import com.gwolf.bigcart.ui.theme.InactiveIndicatorColor
import com.gwolf.bigcart.ui.theme.PrimaryDarkColor
import com.gwolf.bigcart.ui.theme.PrimaryTextColor
import com.gwolf.bigcart.ui.theme.SecondaryTextColor
import com.gwolf.bigcart.ui.theme.poppinsFontFamily
import com.gwolf.bigcart.util.OnBoardingPage

@Composable
fun WelcomeScreen() {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
        OnBoardingPage.Fourth
    )
    val pagerState = rememberPagerState(
        pageCount = { pages.size }
    )
    HorizontalPager(
        state = pagerState
    ) {position ->
        PagerScreen(onBoardingPage = pages[position])
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        PagerIndicator(pagerState)
        CustomButton(
            text = R.string.get_started
        ) {
            
        }
    }
}

@Composable
fun PagerIndicator(
    pagerState: PagerState
) {
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) PrimaryDarkColor else InactiveIndicatorColor
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp, vertical = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 40.dp),
                text = stringResource(id = onBoardingPage.title),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = PrimaryTextColor,
                textAlign = TextAlign.Center
            )
            if(onBoardingPage.icon != 0) {
                Spacer(modifier = Modifier.size(12.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .scale(1.5f),
                    painter = painterResource(id = onBoardingPage.icon),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier,
                text = stringResource(id = onBoardingPage.description),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = SecondaryTextColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}

@Preview(showBackground = true)
@Composable
fun FirstPagerScreenPreview() {
    PagerScreen(OnBoardingPage.First)
}

@Preview(showBackground = true)
@Composable
fun SecondPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Second)
}

@Preview(showBackground = true)
@Composable
fun ThirdPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Third)
}

@Preview(showBackground = true)
@Composable
fun FourthPagerScreenPreview() {
    PagerScreen(OnBoardingPage.Fourth)
}