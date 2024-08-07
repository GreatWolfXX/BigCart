package com.gwolf.bigcart.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gwolf.bigcart.R

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int = 0,
    @StringRes val description: Int
) {
    data object First : OnBoardingPage(
        image = R.drawable.onboarding_1,
        title = R.string.welcome_to_title,
        icon = R.drawable.app_icon,
        description = R.string.onboarding_mock_desc
    )

    data object Second : OnBoardingPage(
        image = R.drawable.onboarding_2,
        title = R.string.buy_quality_title,
        description = R.string.onboarding_mock_desc
    )

    data object Third : OnBoardingPage(
        image = R.drawable.onboarding_3,
        title = R.string.buy_premium_title,
        description = R.string.onboarding_mock_desc
    )

    data object Fourth : OnBoardingPage(
        image = R.drawable.onboarding_4,
        title = R.string.get_discounts_title,
        description = R.string.onboarding_mock_desc
    )
}