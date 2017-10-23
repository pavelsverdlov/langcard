package com.svp.infrastructure.mvpvs

import android.util.Log

import com.svp.infrastructure.mvpvs.presenter.IPresenter
import com.svp.infrastructure.mvpvs.presenter.Presenter

import java.util.ArrayList
import java.util.HashMap

class PresenterContainer {
    interface IPresenterCreator {
        fun create(): IPresenter
    }

    private fun getPresenters(type: Class<*>): ArrayList<IPresenter> {
        val press = ArrayList<IPresenter>()
        val p = creator[type]

        //for (IPresenterCreator p: creators) {
        val presenter: IPresenter
        if (presenters.containsKey(type)) {
            presenter = presenters[type]!!
        } else {
            if (p == null) {
                throw InternalError("No any present creators for current View")
            }
            presenter = p.create()
            presenters.put(type, presenter)
        }
        press.add(presenter)
        //}

        return press
    }

    operator fun <P : Presenter<*, *>> get(viewType: Class<*>): P =
            (getPresenters(viewType)[0] as P)


    companion object {

        private val creator: HashMap<Class<*>, IPresenterCreator> = HashMap()
        private val presenters: HashMap<Class<*>, IPresenter> = HashMap<Class<*>, IPresenter>()

        fun register(viewType: Class<*>, cr: IPresenterCreator) {
            creator.put(viewType, cr)
        }
    }

}
