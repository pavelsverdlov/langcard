package inside.langcard.presentation.main

import android.content.Intent
import android.os.Bundle
import com.svp.infrastructure.mvpvs.bundle.BundleProvider
import com.svp.infrastructure.mvpvs.bundle.IBundleProvider
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.CommutativePresenter
import com.svp.infrastructure.mvpvs.presenter.IPresenter
import com.svp.infrastructure.mvpvs.presenter.Presenter
import inside.langcard.MainActivity
import inside.langcard.data.CardRepository
import inside.langcard.domain.Consts
import inside.langcard.domain.interactors.GetCardsIteractor
import inside.langcard.domain.model.CardDictionaryModel
import inside.langcard.domain.model.CardModel
import inside.langcard.presentation.ActivityOperationResult
import inside.langcard.presentation.UserSettings
import inside.langcard.presentation.bundles.EditCardBundle
import java.util.*

/**
 * Created by Pasha on 10/22/2017.
 */
class MainPresenter(override val id: UUID, val settings : UserSettings) : CommutativePresenter<MainActivity, MainActivity.ViewState>() {



    private var seletctedDictionary : CardDictionaryModel = Consts.dictionaryAll


    override fun onAttachedView(view: MainActivity, intent: Intent) {
    }

    override fun incomingResultFrom(from: ActivityOperationItem, data: Intent) {

    }

    override fun getOperation(code: Int) = ActivityOperationResult.get(code)

    fun addNewCard(){
        commutator.goTo(ActivityOperationResult.AddEditCard)
    }

    fun getCards(): List<CardModel> = GetCardsIteractor(settings.storage).handle(seletctedDictionary)
    fun editCard(card: CardModel) {
        val bundle = EditCardBundle()
        bundle.putCard(card)

        commutator.goTo(ActivityOperationResult.AddEditCard, bundle)
    }

}