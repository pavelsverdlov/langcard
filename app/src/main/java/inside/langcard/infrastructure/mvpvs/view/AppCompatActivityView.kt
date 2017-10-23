package com.svp.infrastructure.mvpvs.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.svp.infrastructure.mvpvs.bundle.BundleContainer
import com.svp.infrastructure.mvpvs.bundle.BundleProvider
import com.svp.infrastructure.mvpvs.bundle.IBundleProvider
import com.svp.infrastructure.mvpvs.PresenterContainer
import com.svp.infrastructure.mvpvs.presenter.Presenter
import com.svp.infrastructure.mvpvs.viewstate.IViewState

open class AppCompatActivityView<in V : IActivityView, VS : IViewState, out P> :
        AppCompatActivity(), IActivityView
        where P : Presenter<V, VS> {

    // public static final UUID id = UUID.randomUUID();

    private val prContainer: PresenterContainer = PresenterContainer()

    protected val presenter: P
        get() = prContainer[this.javaClass]
    // private final BundleContainer bundleContainer;

    init {
        //  bundleContainer = new BundleContainer();
    }

    override fun showError(stringErrorWrapper: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //bundleProvider = bundleContainer.get(this.getClass(),BundleProvider.getBundle(savedInstanceState,this));
        super.onCreate(savedInstanceState)
    }

    override fun <V> executeAction(action: IViewAction<V>) where V : IActivityView{
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    //    protected final <B extends IBundleProvider> B getBundle(){
    //        return (B)bundleProvider;
    //    }
}
