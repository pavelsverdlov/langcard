package com.svp.infrastructure.common


import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.os.PowerManager
import android.os.PowerManager.WakeLock
import android.util.Log

object SystemUtils {

    private val TAG = SystemUtils::class.java.simpleName

    /**
     * Get the My Tracks version from the manifest.
     *
     * @return the version, or an empty string in case of failure.
     */
    fun getMyTracksVersion(context: Context): String {
        try {
            val pi = context.packageManager
                    .getPackageInfo("svp.com.dontmissplaces", PackageManager.GET_META_DATA)
            return pi.versionName
        } catch (e: NameNotFoundException) {
            Log.w(TAG, "Failed to get version info.", e)
            return ""
        }

    }

    /**
     * Tries to acquire a partial wake lock if not already acquired. Logs errors
     * and gives up trying in case the wake lock cannot be acquired.
     */

    /**
     * Acquire a wake lock if not already acquired.
     *
     * @param context the context
     * @param wakeLock wake lock or null
     */
    @SuppressLint("Wakelock")
    fun acquireWakeLock(context: Context, wakeLock: WakeLock?): WakeLock? {
        var wakeLock = wakeLock
        Log.i(TAG, "Acquiring wake lock.")
        try {
            val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            if (powerManager == null) {
                Log.e(TAG, "Power manager null.")
                return wakeLock
            }
            if (wakeLock == null) {
                wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG)
                if (wakeLock == null) {
                    Log.e(TAG, "Cannot create a new wake lock.")
                    return null
                }
            }
            if (!wakeLock.isHeld) {
                wakeLock.acquire()
                if (!wakeLock.isHeld) {
                    Log.e(TAG, "Cannot acquire wake lock.")
                }
            }
        } catch (e: RuntimeException) {
            Log.e(TAG, e.message, e)
        }

        return wakeLock
    }
}