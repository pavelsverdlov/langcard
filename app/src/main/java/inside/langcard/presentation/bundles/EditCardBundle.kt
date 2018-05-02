package inside.langcard.presentation.bundles

import android.content.Intent
import com.svp.infrastructure.mvpvs.bundle.BundleProvider
import inside.langcard.domain.model.CardModel

/**
 * Created by Pasha on 5/2/2018.
 */
class EditCardBundle : BundleProvider {

    constructor(intent: Intent):super(intent){

    }
    constructor() : super(null) {

    }

    final val key : String = "editable_card_key"
    fun putCard(card: CardModel) {
        bundle.putString(key, card.id)
    }

    fun getIdCard() : String =  bundle.getString(key)
}