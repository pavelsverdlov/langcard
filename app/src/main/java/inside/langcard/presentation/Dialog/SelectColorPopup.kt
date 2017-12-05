package inside.langcard.presentation.Dialog

import android.app.AlertDialog
import android.view.View

/**
 * Created by Maxim on 12/3/2017.
 */
class SelectColorPopup {

    lateinit var colors:Array<CardColors>

    fun selectColorPopup(view: View){

        colors = CardColors.values()
        val builder:AlertDialog.Builder = AlertDialog.Builder(view.context)

    }
}