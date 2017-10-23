package com.svp.infrastructure.mvpvs.view


import android.app.Activity

interface IViewAction<in V> where V : IActivityView {
    fun execute(view: V)
}
