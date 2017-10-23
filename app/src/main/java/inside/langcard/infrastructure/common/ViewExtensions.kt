package com.svp.infrastructure.common

import android.app.Activity
import android.view.View

object ViewExtensions {
    fun <T : View> findViewById(view: View, id: Int): T {
        return view.findViewById<View>(id) as T
    }

    fun <T : View> findViewById(view: Activity, id: Int): T {
        return view.findViewById<View>(id) as T
    }

    fun <T : View> setOnClickListener(view: Activity, id: Int, l: View.OnClickListener): T {
        val v = view.findViewById<View>(id) as T
        v.setOnClickListener(l)
        return v
    }

    fun <T : View> setOnLongClickListener(view: Activity, id: Int, l: View.OnLongClickListener): T {
        val v = view.findViewById<View>(id) as T
        v.setOnLongClickListener(l)
        return v
    }
}
