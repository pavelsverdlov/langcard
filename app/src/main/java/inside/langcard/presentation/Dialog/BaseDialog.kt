package inside.langcard.presentation.Dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import inside.langcard.R
import android.widget.ImageButton
import android.widget.TextView
import com.svp.infrastructure.common.ViewExtensions
import inside.langcard.presentation.Dialog.YesNoDialog.OnYesNoClickListener



/**
 * Created by Maxim on 11/8/2017.
 */
abstract class BaseDialog {
    protected lateinit var dialog : Dialog
    lateinit var view: View

   fun show() = dialog.show()
    fun close() = dialog.cancel()
    fun alert(activity: Activity, title: String, message: String): AlertDialog? {
        return AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i: Int ->
                    @Override
                    fun onClick(dialog: DialogInterface, which: Int) {
                    }
                }).create()

    }
}

interface IDialogListener{}

    class YesNoDialog : BaseDialog() {
        interface OnYesNoClickListener : IDialogListener {
            fun onYesClick()
            fun onNoClick()
        }



        fun create(context: Context, inflater: LayoutInflater): YesNoDialog {
            view = inflater.inflate(R.layout.yes_no_dialog, null)
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setView(view)
            dialog = builder.create()


            return this
        }

        fun create(activity: Activity): YesNoDialog {
            return create(activity, activity.layoutInflater)
        }



        fun setOnYesNoClickListener(listener: OnYesNoClickListener): YesNoDialog {
            ViewExtensions.findViewById<ImageButton>(view, R.id.yesnodialog_bottom_btn_no)
                    .setOnClickListener({
                        listener.onNoClick()
                        dialog.cancel()
                    })
            ViewExtensions.findViewById<ImageButton>(view, R.id.yesnodialog_bottom_btn_ok)
                    .setOnClickListener({
                        listener.onYesClick()
                        dialog.cancel()
                    })
            return this
        }
    }

    class EditDialog : BaseDialog() {
        interface OnOkClickListener : IDialogListener{
            fun onOkClick(newText : String)
        }

        fun create(context: Context, inflater: LayoutInflater): EditDialog{
            view = inflater.inflate(R.layout.fragment_add_dictionary_popup, null)
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setView(view)
            dialog = builder.create()


            val no:ImageButton = view.findViewById(R.id.actionbar_bottom_btn_no)
            no.setOnClickListener(View.OnClickListener {
                dialog.cancel()
            })

            return this
        }
        fun create(activity: Activity): EditDialog{
            return create(activity, activity.layoutInflater)
        }

        fun getInputText() : String{
            val editText: EditText =view.findViewById(R.id.popup_add_dictionary_text)

            return editText.text.toString()
        }

        fun setOnOkClickListener(listener: OnOkClickListener): EditDialog{
            ViewExtensions.findViewById<ImageButton>(view, R.id.actionbar_bottom_btn_ok)
                    .setOnClickListener({
                        listener.onOkClick(getInputText())
                        dialog.cancel()
                    })
            return this
        }
        fun setInputText(text:String): EditDialog{
            val editText: EditText = view.findViewById(R.id.popup_add_dictionary_text)
            editText.setText(text)
            return this
        }

          fun show(title: String){
              ViewExtensions.findViewById<TextView>(view, R.id.edit_dialog_title)
                      .setText(title)
                      dialog.show()
        }

    }

class ViewDialog(val activ: Activity) {
    fun show(listener: IDialogListener) {
        when(listener){
            is YesNoDialog.OnYesNoClickListener -> YesNoDialog()
                    .create(activ)
                    .setOnYesNoClickListener(listener)
                    .show()
            is EditDialog.OnOkClickListener -> EditDialog()
                    .create(activ)
                    .setOnOkClickListener(listener)
                    .show()
        }
    }




}
