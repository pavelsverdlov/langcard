package com.svp.infrastructure.mvpvs.presenter

import android.app.Activity
import android.content.Intent

import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.ViewStateContainer
import com.svp.infrastructure.mvpvs.viewstate.IViewState

import java.util.UUID

abstract class Presenter<in V : IActivityView, VS : IViewState> : IPresenter {
    private val vsContainer: ViewStateContainer = ViewStateContainer()
    protected lateinit var state: VS

    fun getUUID(): UUID = id

    fun attachView(view: V) {
        state = vsContainer.addView(view)
        onAttachedView(view)
    }

    fun detachView(view: V) {
        //vsContainer.removeView(view);
        state.saveState()
        onDetachedView(view)
    }

    fun onBackPressed(view: V){
        //state.onBackPressed
        //TODO:
    }

    protected open fun onAttachedView(view: V) {}
    protected open fun onDetachedView(view: V) {}

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

    }

    companion object {
        val id = UUID.randomUUID()
    }

}
