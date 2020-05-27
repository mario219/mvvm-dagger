package com.example.blockone_onboarding.utils

import android.app.Activity
import com.example.blockone_onboarding.screens.MainActivity

fun Activity.hideActionBar() {
    (this as MainActivity).supportActionBar?.hide()
}

fun Activity.showActionBar() {
    (this as MainActivity).supportActionBar?.show()
}