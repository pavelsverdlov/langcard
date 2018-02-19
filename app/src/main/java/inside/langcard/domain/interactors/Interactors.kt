package inside.langcard.domain.interactors

import inside.langcard.data.CardRepository
import inside.langcard.data.DatabaseStorage
import inside.langcard.data.dto.LearnCard
import inside.langcard.domain.cmd.AddNewCardCommand
import inside.langcard.domain.cmd.AddNewCardCommandData
import inside.langcard.domain.cmd.GetCardsCommand
import inside.langcard.domain.model.CardDictionaryModel
import inside.langcard.domain.model.CardModel

/**
 * Created by Pasha on 10/15/2017.
 */
class AddNewCardIteractor : BaseInteractor() {

    fun handle(model : CardModel){
        model.let {
            LearnCard().apply {
                first.learningText = it.first.learningText
                second.learningText = it.second.learningText

                learningSide = it.sideType.ordinal
            }
        }.let {
            AddNewCardCommand().execute(AddNewCardCommandData(it))
        }
    }
}


class GetCardsIteractor(val storage : DatabaseStorage) : BaseInteractor(){

    fun handle(dictionary: CardDictionaryModel): List<CardModel> {
        val repo : CardRepository = CardRepository(storage)
        try {
            repo.open()
            GetCardsCommand().execute(repo)

            //TODO : remake fake implementation
            return getFakeCards()
        }finally {
            repo.close()
        }



    }
    fun getFakeCards() : List<CardModel>{
        return MutableList(10){
            index -> CardModel(index.toString())
        }
    }
}