package com.example.hammersystemtest.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Menu(
    @StringRes val stringTitleResourceId: Int,
    @StringRes val stringDescriptionResourceId: Int,
    @StringRes val stringPriceResourceId: Int,
    @DrawableRes val imageResourceId: Int
)