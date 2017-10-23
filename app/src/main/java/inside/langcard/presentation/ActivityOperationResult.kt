package inside.langcard.presentation

import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem

/**
 * Created by Pasha on 10/22/2017.
 */
class ActivityOperationResult{
    companion object {
        fun get(code : Int) = ActivityOperationItem(0)
    }
}