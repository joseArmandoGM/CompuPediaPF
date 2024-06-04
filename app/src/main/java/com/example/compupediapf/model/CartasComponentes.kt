package com.example.compupediapf.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CartasComponentes(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceId2: Int,
    @DrawableRes val imageResourceId: Int
)
