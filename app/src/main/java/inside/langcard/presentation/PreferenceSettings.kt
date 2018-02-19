package inside.langcard.presentation

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.content.SharedPreferences
import android.R.id.edit
import android.preference.PreferenceFragment
import android.preference.Preference

/**
 * Created by Pasha on 10/28/2017.
 */
abstract class PreferenceSettings(val context : Context){
    companion object {
        private val KEY_PREFERENCES_VERSION = "key_preferences_version"
        private val PREFERENCES_VERSION = 1
    }

    private val preferences: SharedPreferences =
            context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    init {
        checkPreferences(preferences)
    }

    fun putString(key: String, value: String) {
        val editor = setter()
        editor.putString(key, value)
        editor.commit()
    }

    fun putInt(key: String, value: Int) {
        val editor = setter()
        editor.putInt(key, value)
        editor.commit()
    }

    operator fun <T> get(key: String, def: T): T {
        return getter().apply {
            when (this.contains(key)){
                false -> def
                true -> {
                    val value = this.all[key]
                    if(value == null){
                        def
                    } else {
                        value
                    }
                }
            }
        } as T


//        val pref = getter()
//        if (!pref.contains(key)) {
//            return def
//        }
//        val `val` =
//        return if (`val` == null) def else `val` as T?
    }

    protected fun getPreference(fragment: PreferenceFragment, key: String): Preference {
        return fragment.findPreference(key)
    }

    private fun getter(): SharedPreferences {
        return preferences//PreferenceManager.getDefaultSharedPreferences(activity,);
    }

    private fun setter(): SharedPreferences.Editor {
        return preferences.edit()
    }

    /**
     * Migration
     */

    @Synchronized private fun checkPreferences(thePreferences: SharedPreferences) {
        val oldVersion = thePreferences.getInt(KEY_PREFERENCES_VERSION, 0).toDouble()

        if (oldVersion == 0.0) {//first application start
            val editor = setter()
            editor.putInt(KEY_PREFERENCES_VERSION, PREFERENCES_VERSION)
            editor.apply()
            return
        }

        if (oldVersion < PREFERENCES_VERSION) {
            val edit = thePreferences.edit()
            //save same data from old preferences
            edit.clear()
            edit.putInt(KEY_PREFERENCES_VERSION, PREFERENCES_VERSION)
            //resave data to new preferences
            edit.apply()
        }
    }
}