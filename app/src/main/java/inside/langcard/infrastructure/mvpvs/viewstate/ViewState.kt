package com.svp.infrastructure.mvpvs.viewstate

import android.app.Activity
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast

import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.view.IViewAction

abstract class ViewState<V : IActivityView> protected constructor(protected var view: V) : IViewState {

    abstract override val activity: Activity

    fun addAction(action: IViewAction<V>) {
        view.executeAction(action)
    }

    override fun refresh(v: IActivityView) {
        (v as V).apply {
            view = this
        }
        restore()
    }

    protected abstract fun restore()

    fun getToast(text: CharSequence): Toast {
        return Toast.makeText(activity, text, Toast.LENGTH_SHORT)
    }

    override fun getSnackbar(text: CharSequence): Snackbar {
        /*
        return Snackbar.make(getActivity().getWindow().getDecorView(),
                    text, Snackbar.LENGTH_LONG)
                .setAction("Action", null);
                */
        //top bar
        val snackbar = Snackbar.make(activity.window.decorView,
                text, Snackbar.LENGTH_INDEFINITE)
        val v = snackbar.view
        val params = v.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        v.layoutParams = params
        return snackbar
    }

    fun getString(id: Int): CharSequence {
        return activity.getString(id)
    }
}