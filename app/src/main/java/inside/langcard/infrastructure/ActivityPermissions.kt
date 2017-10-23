package com.svp.infrastructure

import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat

import com.svp.infrastructure.common.PermissionUtils

class ActivityPermissions(private val activity: FragmentActivity) {

    var isFineLocationGranted: Boolean = false
        private set
    /**
     * Flag indicating whether a requested permission has been denied after returning in
     */
    var fineLocationPermissionDenied = false

    fun isFineLocationGranted(permissions: Array<String>, grantResults: IntArray): Boolean {
        return isPermissionGranted(permissions, grantResults, Manifest.permission.ACCESS_FINE_LOCATION)
    }

    fun checkPermissionFineLocation(): Boolean {
        isFineLocationGranted = checkPermissionFineLocation(activity, Manifest.permission.ACCESS_FINE_LOCATION)
        return isFineLocationGranted
    }

    fun checkPermissionCoarseLocation(): Boolean {
        return checkPermissionFineLocation(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    fun checkPermissionExternalStorage() {
        checkPermissionFineLocation(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    fun checkPermissionNetwork(): Boolean {
        return checkPermissionFineLocation(activity, Manifest.permission.ACCESS_NETWORK_STATE)
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    fun showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(activity.supportFragmentManager, "dialog")
    }

    companion object {
        /**
         * Request code for location permission request.
         */
        val LOCATION_PERMISSION_REQUEST_CODE = 1

        private fun checkPermissionFineLocation(activity: FragmentActivity, manifestPermission: String): Boolean {
            val state = ContextCompat.checkSelfPermission(activity, manifestPermission)
            if (state != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.READ_CONTACTS)) {

                } else {
                    PermissionUtils.requestPermission(activity, LOCATION_PERMISSION_REQUEST_CODE,
                            manifestPermission, false)
                }
                return false
            }
            return true
        }

        private fun isPermissionGranted(permissions: Array<String>, grantResults: IntArray, manifestPermission: String): Boolean {
            return PermissionUtils.isPermissionGranted(permissions, grantResults, manifestPermission)
        }
    }


}
