package com.svp.infrastructure.mvpvs.view

import android.app.Activity
import android.support.v4.app.FragmentActivity

import com.svp.infrastructure.mvpvs.presenter.Presenter
import com.svp.infrastructure.mvpvs.PresenterContainer
import com.svp.infrastructure.mvpvs.viewstate.IViewState

/**
 * Created by Pasha on 3/19/2016.
 */
class FragmentActivityView<in V : IActivityView, VS : IViewState, out P> :
        FragmentActivity(), IActivityView where P : Presenter<V, VS> {
    internal var prContainer: PresenterContainer = PresenterContainer()

    protected val presenter: P
        get() = prContainer.get(this.javaClass)

    override fun showError(stringErrorWrapper: String) {

    }

    override fun <V : IActivityView> executeAction(action: IViewAction<V>) {
        action.execute(this as V)
    }

    override fun onStart() {
        presenter.attachView(this as V)
        super.onStart()
    }

    override fun onStop() {
        presenter.detachView(this as V)
        super.onStop()
    }
}
