package com.svp.infrastructure.mvpvs.view

import android.app.Activity

import java.util.UUID

interface IActivityView {
    //UUID getId();
    fun showError(stringErrorWrapper: String)

    fun <V> executeAction(action: IViewAction<V>) where V : IActivityView
}
