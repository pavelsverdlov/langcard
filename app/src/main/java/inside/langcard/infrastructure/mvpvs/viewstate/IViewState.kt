package com.svp.infrastructure.mvpvs.viewstate

import android.app.Activity
import android.support.design.widget.Snackbar

import com.svp.infrastructure.mvpvs.view.IActivityView

interface IViewState {
    val activity: Activity
    fun saveState()
    fun refresh(view: IActivityView)
    fun getSnackbar(text: CharSequence): Snackbar
}
