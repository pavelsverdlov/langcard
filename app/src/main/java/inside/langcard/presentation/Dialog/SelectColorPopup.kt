package inside.langcard.presentation.Dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import inside.langcard.R

/**
 * Created by Maxim on 12/3/2017.
 */

class SelectColorPopup:BaseDialog() {

    //val colors:Array<CardColors> = CardColors.values()

    fun create(context: Context, inflater: LayoutInflater): SelectColorPopup{
        view = inflater.inflate(R.layout.select_colors_template, null)
        val builder:AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setView(view)
        dialog = builder.create()




        val grid:GridView = view.findViewById(R.id.grid_colors)
        grid.adapter = DisplayColorAdapter(inflater)
        grid.setOnItemClickListener(AdapterView.OnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            dialog.cancel()
            })

        return this
    }

    open class DisplayColorAdapter(val inflater: LayoutInflater) : BaseAdapter(){

        override fun getCount(): Int {
        return CardColors.values().size
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getItem(position: Int): Any {
        return CardColors.values()[position]
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val itemTemplate: View = inflater.inflate(R.layout.select_color_item_template, parent, false)
            val container: FrameLayout = itemTemplate.findViewById(R.id.select_color_frame)
            //container.setBackgroundColor(CardColors.)
            return itemTemplate
        }


    }
}