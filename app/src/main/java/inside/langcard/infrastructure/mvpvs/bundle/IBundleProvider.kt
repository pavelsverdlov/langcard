package com.svp.infrastructure.mvpvs.bundle

import android.content.Intent
import android.os.Bundle

/**
 * Created by Pasha on 5/8/2016.
 */
interface IBundleProvider {

    val previousActionText: CharSequence
    fun putInto(intent: Intent)
    fun putActionText(text: CharSequence): IBundleProvider
}
