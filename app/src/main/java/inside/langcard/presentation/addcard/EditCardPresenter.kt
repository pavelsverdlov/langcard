package inside.langcard.presentation.addcard

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.CommutativePresenter
import inside.langcard.domain.model.CardModel
import inside.langcard.presentation.ActivityOperationResult
import inside.langcard.presentation.Dialog.*
import java.util.*

/**
 * Created by Pasha on 10/23/2017.
 */
class EditCardPresenter(override val id: UUID) : CommutativePresenter<EditCardActivity, EditCardActivity.ViewState>() {

    lateinit var activ : Activity

    override fun incomingResultFrom(from: ActivityOperationItem, data: Intent) {
        //get model from intend and set model to view state if it editing,
        // generate new one if it is addition new
        state.model= CardModel("112")
    }

    override fun onAttachedView(view: EditCardActivity, intent: Intent) {
        activ = view
        //get model from intend and set model to view state if it editing,
        // generate new one if it is addition new
        state.model = CardModel("112")
    }

    override fun onDetachedView(view: EditCardActivity) {
        //AddNewCardIteractor().handle(state.model)
        super.onDetachedView(view)
    }

    override fun getOperation(code: Int)= ActivityOperationResult.get(code)

    fun click1(){
        val dialog = Dialog(activ)

        state.setText("click1")

        ViewDialog(activ).show(object : YesNoDialog.OnYesNoClickListener{
            override fun onYesClick(){

            }
            override fun onNoClick(){

            }
        })
    }
    fun click2(){

        state.setText("click2")
        ViewDialog(activ).show(object: EditDialog.OnOkClickListener{
            override fun onOkClick(newText: String) {

            }
        })
    }
    fun click3(){
        state.setText("click3")
        ViewDialog(activ).show(object:ShowCardPopup.OnShowTicketClickListener{
            override fun onOkClick() {

            }

            override fun onNoClick() {
            }

            override fun onEditClick() {

            }
        })
    }
}