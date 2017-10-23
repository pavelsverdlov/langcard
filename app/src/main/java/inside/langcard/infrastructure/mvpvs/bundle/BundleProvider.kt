package com.svp.infrastructure.mvpvs.bundle


import android.app.Activity
import android.content.Intent
import android.os.Bundle

import java.util.UUID

class BundleProvider protected constructor(b: Bundle?) : IBundleProvider {

    protected val bundle: Bundle


    override val previousActionText: CharSequence
        get() = bundle.getCharSequence(previousActionKey, null)

    protected constructor(intent: Intent) : this(intent.extras) {}

    init {
        this.bundle = b ?: Bundle()
    }

    override fun putInto(intent: Intent) {
        intent.putExtras(bundle)
    }

    override fun putActionText(text: CharSequence): IBundleProvider {
        bundle.putCharSequence(previousActionKey, text)
        return this
    }

    companion object {
        fun getBundle(savedInstanceState: Bundle?, activity: Activity): Bundle? {
            return savedInstanceState ?: activity.intent.extras
        }

        fun create(bundle: Bundle): IBundleProvider {
            return BundleProvider(bundle)
        }

        fun create(): IBundleProvider {
            return BundleProvider(Bundle())
        }

        private val previousActionKey = UUID.randomUUID().toString()
    }

}
