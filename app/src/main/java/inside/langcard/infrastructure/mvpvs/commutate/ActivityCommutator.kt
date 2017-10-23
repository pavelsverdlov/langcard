package com.svp.infrastructure.mvpvs.commutate

import android.app.Activity
import android.content.Intent

import com.svp.infrastructure.mvpvs.bundle.IBundleProvider

import java.util.HashMap

open class ActivityCommutator(private val element: ICommutativeElement) {

    /*catch result from onActivityResult on main activity*/
    fun backTo(bundleProvider: IBundleProvider?) {
        val activity = element.activity

        val intent = Intent()

        bundleProvider?.putInto(intent)

        activity.parent.setResult(element.operation.toInt(), intent)
        activity.setResult(element.operation.toInt(), intent)
        activity.finish()
    }

    private fun goTo(_class: Class<*>, bundleProvider: IBundleProvider?): Activity {
        val activity = element.activity

        val intent = Intent(activity.baseContext, _class)

        bundleProvider?.putInto(intent)

        activity.startActivityForResult(intent, element.operation.toInt())
        return activity
    }


    fun goTo(operationTo: ActivityOperationItem) {
        activities[operationTo]?.let {
            goTo(it, null)
        }
        //goTo(activities[operationTo], null)
    }

    fun goTo(operationTo: ActivityOperationItem, bundleProvider: IBundleProvider) {
        activities[operationTo]?.let {
            goTo(it, bundleProvider)
        }

    }

    companion object {
        protected val activities: HashMap<ActivityOperationItem, Class<*>> =
                HashMap<ActivityOperationItem, Class<*>>()


            fun register(key: ActivityOperationItem, value: Class<*>) {
                activities.put(key, value)
            }

    }
}
