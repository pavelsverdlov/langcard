package com.svp.infrastructure.common.view

import android.app.Activity
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Adapter
import android.widget.ListView

import java.lang.reflect.Field

object ListViewEx {
    /**
     * calculate height by Adapter items amd set it to ListView height params
     */
    fun setHeightListView(listView: ListView, listAdapter: Adapter) {
        var totalHeight = 0
        for (i in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(i, null, listView)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }

        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }

    @Throws(NoSuchFieldException::class, IllegalArgumentException::class, IllegalAccessException::class)
    fun getMenuItemsView(a: Activity, m: Menu) {
        val homeButton = a.findViewById<View>(android.R.id.home)
        var parentOfHome = homeButton.parent.parent //ActionBarView is parent of home ImageView, see layout file in sources

        if (!parentOfHome.javaClass.name.contains("ActionBarView")) {
            parentOfHome = parentOfHome.parent
            val absAbv = parentOfHome.javaClass.superclass //ActionBarView -> AbsActionBarView class
            val actionMenuPresenterField = absAbv.getDeclaredField("mActionMenuPresenter")
            actionMenuPresenterField.isAccessible = true
            val actionMenuPresenter = actionMenuPresenterField.get(parentOfHome)
            val actionMenuViewField = actionMenuPresenter.javaClass.superclass.getDeclaredField("mMenuView")
            actionMenuViewField.isAccessible = true
            val actionMenuView = actionMenuViewField.get(actionMenuPresenter)
            val childrenField = actionMenuView.javaClass.superclass.superclass.getDeclaredField("mChildren")
            childrenField.isAccessible = true
            val menuField = actionMenuPresenter.javaClass.superclass.getDeclaredField("mMenu")
            menuField.isAccessible = true
            val menu = menuField.get(actionMenuPresenter)
            val menuItemsAsViews = childrenField.get(actionMenuView) as Array<Any>
            val longListener = View.OnLongClickListener {
                true
                // return listener.onMenuItemLongClik(m.findItem(v.getId()));
            }
            for (menuView in menuItemsAsViews) {
                val v = menuView as View
                v.setOnLongClickListener(longListener)
            }


        }
    }
}
