package com.svp.infrastructure.mvpvs.bundle

import android.os.Bundle
import android.util.Log

import com.svp.infrastructure.mvpvs.ICreator
import java.util.HashMap

class BundleContainer {
    interface IBundleCreator {
        fun create(bundle: Bundle): IBundleProvider
    }

    operator fun <P : IBundleProvider> get(viewType: Class<*>, bundle: Bundle): P? {
        val p = creator[viewType]

        if (p == null) {
            Log.w(this.javaClass.name, "No any present creators for current bundle")
            return null
        }

        return p.create(bundle) as P
    }

    companion object {
        private val creator: HashMap<Class<*>, IBundleCreator>

        init {
            creator = HashMap()
        }

        fun register(viewType: Class<*>, cr: IBundleCreator) {
            creator.put(viewType, cr)
        }
    }
}
