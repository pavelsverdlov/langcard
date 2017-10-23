package com.svp.infrastructure.common.view

import android.content.Context
import android.database.Cursor
import android.support.v4.widget.CursorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class BaseCursorAdapter<T : ICursorParcelable>(context: Context, c: Cursor) : CursorAdapter(context, c) {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun newView(context: Context, cursor: Cursor, parent: ViewGroup): View {
        val item = getView(inflater, parent)
        val obj = createParcelableObject()
        obj.initView(item)
        item.tag = obj

        item.setOnClickListener { v -> onItemClick(v, v.tag as T) }

        return item
    }

    override fun bindView(convertView: View, context: Context, cursor: Cursor) {
        val obj = convertView.tag as ICursorParcelable
        obj.parse(cursor)
    }

    abstract fun createParcelableObject(): ICursorParcelable
    //inflater.inflate(R.layout.activity_history_tracks_item_template, parent, false)
    abstract fun getView(inflater: LayoutInflater, parent: ViewGroup): View

    abstract fun onItemClick(view: View, item: T)
}
