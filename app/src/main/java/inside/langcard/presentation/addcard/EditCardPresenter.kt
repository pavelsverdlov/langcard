package inside.langcard.presentation.addcard

import android.content.Intent
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.CommutativePresenter
import inside.langcard.presentation.ActivityOperationResult
import java.util.*

/**
 * Created by Pasha on 10/23/2017.
 */
class EditCardPresenter(override val id: UUID) : CommutativePresenter<EditCardActivity, EditCardActivity.ViewState>() {
    override fun incomingResultFrom(from: ActivityOperationItem, data: Intent) {
    }

    override fun onAttachedView(view: EditCardActivity, intent: Intent) {
    }

    override fun getOperation(code: Int)= ActivityOperationResult.get(code)

    fun click1(){
        state.setText("click1")
    }
    fun click2(){
        state.setText("click2")
    }
    fun click3(){
        state.setText("click3")
    }
}