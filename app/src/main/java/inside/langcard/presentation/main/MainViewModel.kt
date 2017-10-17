package inside.langcard.presentation.main

import android.arch.lifecycle.ViewModel
import inside.langcard.presentation.core.SingleLiveEvent

/**
 * Created by Pasha on 10/15/2017.
 */
class MainViewModel : ViewModel(){
    val addNewCardEvent = SingleLiveEvent<Void>()

    fun addNewCard(){
        addNewCardEvent.call()
    }
}