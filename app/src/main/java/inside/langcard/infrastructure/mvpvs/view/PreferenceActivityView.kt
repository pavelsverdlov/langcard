package com.svp.infrastructure.mvpvs.view

import android.preference.PreferenceActivity

import com.svp.infrastructure.mvpvs.PresenterContainer
import com.svp.infrastructure.mvpvs.presenter.Presenter
import com.svp.infrastructure.mvpvs.viewstate.IViewState

class PreferenceActivityView<in V : IActivityView, VS : IViewState, out P : Presenter<V, VS>> : PreferenceActivity(), IActivityView {
    private val prContainer: PresenterContainer = PresenterContainer()

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
