package inside.langcard.presentation.main

import android.content.Intent
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.CommutativePresenter
import com.svp.infrastructure.mvpvs.presenter.IPresenter
import com.svp.infrastructure.mvpvs.presenter.Presenter
import inside.langcard.MainActivity
import inside.langcard.presentation.ActivityOperationResult
import java.util.*

/**
 * Created by Pasha on 10/22/2017.
 */
class MainPresenter(override val id: UUID) : CommutativePresenter<MainActivity, MainActivity.ViewState>() {
    override fun onAttachedView(view: MainActivity, intent: Intent) {
    }

    override fun incomingResultFrom(from: ActivityOperationItem, data: Intent) {

    }

    override fun getOperation(code: Int) = ActivityOperationResult.get(code)

    fun addNewCard(){
        commutator.goTo(ActivityOperationResult.AddEditCard)
    }
}