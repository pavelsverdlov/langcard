package com.svp.infrastructure.common.view

import android.database.Cursor
import android.view.View

interface ICursorParcelable {
    fun parse(cursor: Cursor)
    fun initView(view: View)
}
