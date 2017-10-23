package inside.langcard.presentation.core

import android.content.Intent
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.viewstate.IViewState
import com.svp.infrastructure.mvpvs.commutate.ICommutativeElement
import com.svp.infrastructure.mvpvs.view.IActivityView
import inside.langcard.presentation.ActivityOperationResult
import java.util.*


/**
 * Created by Pasha on 10/22/2017.
 */
open class CommutativePreferencePresenter<
        V : IActivityView,
        VS : IViewState>(override val id: UUID) :
        com.svp.infrastructure.mvpvs.commutate.CommutativePresenter<V, VS>() where V : ICommutativeElement {

    override fun incomingResultFrom(from: ActivityOperationItem, data: Intent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    protected lateinit var userSettings: UserPreferenceSettings


    override fun getOperation(code: Int)= ActivityOperationResult.get(code)

    override fun onAttachedView(view: V, intent: Intent) {
        userSettings = UserPreferenceSettings(state.activity)
    }
}