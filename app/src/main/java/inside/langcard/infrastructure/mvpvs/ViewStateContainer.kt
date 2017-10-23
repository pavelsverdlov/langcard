package com.svp.infrastructure.mvpvs

import android.app.Activity

import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.viewstate.IViewState

import java.util.HashMap



class ViewStateContainer {

    interface IViewStateCreator {
        fun <V : IActivityView> create(view: V): IViewState
    }

    fun <V : IActivityView, VS : IViewState> addView(view: V): VS {
        val type = view.javaClass

        if (states.containsKey(type)) {
            states[type]!!.refresh(view)
        } else {
            val t : IActivityView = view
            states.put(type, creators[type]!!.create(t))
        }
        return states[type] as VS
    }

    fun <V : IActivityView> removeView(view: V) {
        //        UUID id = view.getId();
        val type = view.javaClass
        states.remove(type)
    }

    companion object {

        private val creators: HashMap<Class<*>, IViewStateCreator> =
                HashMap<Class<*>, IViewStateCreator>()
        private val states: HashMap<Class<*>, IViewState> =
                HashMap<Class<*>, IViewState>()

        fun register(type: Class<*>, cr: IViewStateCreator) {
            creators.put(type, cr)
        }
    }
}
