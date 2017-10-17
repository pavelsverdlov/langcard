package inside.langcard.presentation

import android.app.Activity
import android.content.Intent
import inside.langcard.presentation.addcard.AddNewCardActivity

/**
 * Created by Pasha on 10/15/2017.
 */

enum class ActivityModes {
    Main,
    AddNewCard
}

class Commutator(private val activity: Activity) {
    fun goTo(mode: ActivityModes){
        when(mode) {
            ActivityModes.AddNewCard -> startActivity(AddNewCardActivity::class.java, AddNewCardActivity.REQUEST_CODE)
            else -> {

            }
        }
    }

    private fun <T : Activity> startActivity(actTo: Class<T>, code: Int) {
        val intent = Intent(activity, actTo)
        activity.startActivityForResult(intent,code)//
    }
}