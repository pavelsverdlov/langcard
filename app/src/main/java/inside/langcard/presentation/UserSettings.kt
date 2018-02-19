package inside.langcard.presentation

import android.os.Environment
import inside.langcard.data.DatabaseStorage
import java.io.File
import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import android.content.SharedPreferences


/**
 * Created by Pasha on 10/28/2017.
 */
class UserSettings(context: Context) : PreferenceSettings(context){
    private val dbName = "db_languagetickets"
    private val appsettings_select_db_path = "appsettings_select_db_path"



    val storage : DatabaseStorage
        get() {
            if(!getter().contains(appsettings_select_db_path)){
                initDB()
            }
            return DatabaseStorage(File(getter().getString(appsettings_select_db_path,null)))
        }


    private fun initDB() {
        val editor = setter()
        //only Application storage fo now

        //init database
        val p1 = context.getExternalFilesDir(Environment.getDataDirectory().absolutePath)
        //create default path for application
        val data = File(p1, "databases")
        //String currentDBPath = "/databases/" + Repository.dbName;
        if(!data.exists()){
            data.mkdirs()
        }
        val path = File(p1, dbName)
        editor.putString(appsettings_select_db_path, path.path)
        editor.commit()

        //
    }

    private fun getter(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    private fun setter(): SharedPreferences.Editor {
        return PreferenceManager.getDefaultSharedPreferences(context).edit()
    }
}
