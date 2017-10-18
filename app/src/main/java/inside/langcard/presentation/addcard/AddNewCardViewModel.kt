package inside.langcard.presentation.addcard

import android.arch.lifecycle.ViewModel
import inside.langcard.presentation.core.SingleLiveEvent

/**
 * Created by Maxim on 10/18/2017.
 */
 class AddNewCardViewModel : ViewModel(){
    val addNewCardEvent = SingleLiveEvent<Void>()

    fun addNewCard(){
            addNewCardEvent.call()
    }
}
