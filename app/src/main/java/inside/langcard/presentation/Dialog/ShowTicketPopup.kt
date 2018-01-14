package inside.langcard.presentation.Dialog

import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.provider.DocumentsContract
import android.sax.RootElement
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.svp.infrastructure.common.StringHelper
import com.svp.infrastructure.common.ViewExtensions
import inside.langcard.R
import inside.langcard.domain.model.CardModel
import inside.langcard.domain.model.SideTypes

/**
 * Created by Maxim on 12/25/2017.
 */
open class ShowTicketPopup: BaseDialog(){
     var type:SideTypes = CardModel().sideType
    val controller:


    interface setOnclickListener: IDialogListener
 fun create(context: Context, inflater: LayoutInflater){
    view = inflater.inflate(R.layout.fragment_ticket_clicked_popup, null)
     val builder:AlertDialog.Builder = AlertDialog.Builder(context)
     builder.setView(view)
     dialog = builder.create()

     val ok:ImageButton = view.findViewById(R.id.actionbar_bottom_btn_ok)
     ok.setOnClickListener(View.OnClickListener {
         fun onClick(v: View) {
             TODO("what is controller.updateTicketCounters(ticket, RootActivityController.CounterTypes.Correct, type);")
             dialog.cancel()
         }
     })

         val no:ImageButton = view.findViewById(R.id.actionbar_bottom_btn_no)
         no.setOnClickListener(View.OnClickListener {
             fun onClick (v:View){
                 TODO("what is controller.updateTicketCounters(ticket, RootActivityController.CounterTypes.Correct, type);")
                 dialog.cancel()
             }
     })


 }

    fun show (tt:CardModel){
    val ticket = tt
        type = ticket.getInvertOfCurrentSideType()
        val txt:TextView = view.findViewById(R.id.popup_show_learning_text)
        txt.setText(StringHelper.joinByLineSeparator(ticket.getLearningText(type)))

        val lang: Button = ViewExtensions.findViewById(view, R.id.popup_show_language)
        lang.setText(ticket.getLanguage(type).getTitle().toUpperCase())  // TODO: find out whats problem with getTitle
        val edit: FloatingActionButton = ViewExtensions.findViewById(view, R.id.actionbar_bottom_btn_edit)

        val id = CardColorProvider().getDrawableBackground(ticket.getBackground())
        val backColor:Int = CardColorProvider().getColorIntSecondBackground(ticket.getBackground())
        view.findViewById<View>(R.id.frame_ticket_clicked_top).setBackground(id)
        view.findViewById<View>(R.id.actionbar_bottom_btn_ok).setBackground(id)
        view.findViewById<View>(R.id.frame_ticket_clicked_base).setBackgroundColor(backColor)
        view.findViewById<View>(R.id.frame_card_popup_separator).setBackgroundColor(backColor)

        edit.setBackgroundTintList(ColorStateList.valueOf(backColor))

       /*
       TODO: will implement when find out what is RootColtroller
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

