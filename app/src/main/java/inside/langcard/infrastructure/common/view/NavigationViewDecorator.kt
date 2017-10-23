package com.svp.infrastructure.common.view


import android.app.Activity
import android.support.design.widget.NavigationView
import android.view.Menu

class NavigationViewDecorator(private val navigation: NavigationView) {

    val menu: Menu
        get() = navigation.menu

    fun setMenu(resourceMenuId: Int) {
        navigation.menu.clear()
        navigation.inflateMenu(resourceMenuId)
    }
}
