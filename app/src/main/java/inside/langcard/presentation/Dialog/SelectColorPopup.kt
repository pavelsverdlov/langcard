package inside.langcard.presentation.Dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.GridView
import inside.langcard.R

/**
 * Created by Maxim on 12/3/2017.
 */
class SelectColorPopup:BaseDialog() {

    lateinit var colors:Array<CardColors>

    fun create(context: Context, inflater: LayoutInflater): SelectColorPopup{
        view = inflater.inflate(R.layout.select_colors_template, null)
        val builder:AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setView(view)
        dialog = builder.create()

        val grid:GridView = view.findViewById(R.id.grid_colors)

        return this
    }


}