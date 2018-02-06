package inside.langcard.presentation.Dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.media.Image
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.svp.infrastructure.common.ViewExtensions
import inside.langcard.R
import inside.langcard.domain.model.CardModel
import inside.langcard.domain.model.SideTypes

/**
 * Created by Maxim on 12/25/2017.
 */
open class ShowCardPopup : BaseDialog(){
     var type:SideTypes = CardModel("111").sideType

    interface OnShowTicketClickListener : IDialogListener{
        fun onNoClick()
        fun onOkClick()
        fun onEditClick()
    }

    fun create(context: Context, inflater: LayoutInflater): ShowCardPopup {
    view = inflater.inflate(R.layout.fragment_ticket_clicked_popup, null)
     val builder:AlertDialog.Builder = AlertDialog.Builder(context)
     builder.setView(view)
     dialog = builder.create()


        return this
 }

    fun create(activity: Activity): ShowCardPopup{
        return create(activity, activity.layoutInflater)
    }

    fun setOnColorClickListener(listener: OnShowTicketClickListener): ShowCardPopup {
        ViewExtensions.findViewById<ImageButton>(view, R.id.actionbar_bottom_btn_ok)
                .setOnClickListener({
                    listener.onOkClick()
                    dialog.cancel()
                })
        ViewExtensions.findViewById<ImageButton>(view, R.id.actionbar_bottom_btn_no)
                .setOnClickListener( {
                    listener.onNoClick()
                    dialog.cancel()
                })
        ViewExtensions.findViewById<ImageButton>(view, R.id.actionbar_bottom_btn_edit)
                .setOnClickListener({
                    listener.onEditClick()
                    dialog.cancel()
                })
        return this
    }


    fun show (tt:CardModel){
    val ticket = tt
        type = ticket.getInvertOfCurrentSideType()
        val txt:TextView = view.findViewById(R.id.popup_show_learning_text)
        txt.setText(ticket.getLearningText(type))

        val lang: Button = ViewExtensions.findViewById(view, R.id.popup_show_language)
        lang.setText(ticket.getLanguage(type).getTitle().toUpperCase())
        val edit: FloatingActionButton = ViewExtensions.findViewById(view, R.id.actionbar_bottom_btn_edit)

        val pr = CardColorProvider()

        val id = pr.getDrawableBackground(ticket.getBackground())
        val backColor:Int = pr.getColorIntSecondBackground(ticket.getBackground())

        view.findViewById<View>(R.id.frame_ticket_clicked_top).setBackground(id)
        view.findViewById<View>(R.id.actionbar_bottom_btn_ok).setBackground(id)
        view.findViewById<View>(R.id.frame_ticket_clicked_base).setBackgroundColor(backColor)
        view.findViewById<View>(R.id.frame_card_popup_separator).setBackgroundColor(backColor)

        edit.setBackgroundTintList(ColorStateList.valueOf(backColor))

       /*
       *  if(controller.getSelectedDictionary().isLearned()) {
            view.findViewById(R.id.actionbar_bottom_btn_ok).setVisibility(View.GONE);
            view.findViewById(R.id.actionbar_bottom_btn_no).setVisibility(View.GONE);

            edit.setImageResource(R.drawable.ic_action_undo);
            edit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    controller.revertToLearning(ticket);
                    dialog.cancel();
                    controller.activity.restartActivity();
                }
            });
        }else{
            edit.setImageDrawable(DrawableEx.getGray(controller.activity,R.drawable.ic_mode_edit_black_24dp));
            edit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.cancel();
                    controller.goToEditTicketActivity();
                }
            });
            lang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    controller.updateCardAsTurnedOver(ticket);
                    show(ticket);
                    controller.activity.updateTicket(ticket);
                }
            });
        }

        dialog.show();
    }

       * */
}}

