package com.svp.infrastructure.mvpvs.commutate

import android.app.Activity
import android.content.Intent

import com.svp.infrastructure.mvpvs.presenter.Presenter
import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.viewstate.IViewState

abstract class CommutativePresenter
    <in V, VS : IViewState> :
        Presenter<V, VS>() where V : IActivityView, V : ICommutativeElement {

    protected lateinit var commutator: ActivityCommutator

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (Activity.RESULT_CANCELED == resultCode) {
            return
        }
        incomingResultFrom(getOperation(resultCode), data)
    }

    protected abstract fun getOperation(code: Int): ActivityOperationItem
    protected abstract fun incomingResultFrom(from: ActivityOperationItem, data: Intent)

    protected override fun onAttachedView(view: V) {
        super.onAttachedView(view)
        commutator = ActivityCommutator(view)

        onAttachedView(view, view.activity.getIntent())
    }

    protected abstract fun onAttachedView(view: V, intent: Intent)
}