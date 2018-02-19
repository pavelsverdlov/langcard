package inside.langcard.domain

import android.content.Context
import inside.langcard.R
import inside.langcard.domain.model.CardDictionaryModel
import inside.langcard.R.string.dictionary_title_learned
import inside.langcard.R.string.dictionary_title_all



/**
 * Created by Pasha on 2/18/2018.
 */
class Consts(val context: Context){

    companion object {
        lateinit var dictionaryAll : CardDictionaryModel
        lateinit var dictionaryLearned : CardDictionaryModel
    }

    fun init(){
        val dictionaryName_All = context.getString(R.string.dictionary_title_all)
        val dictionaryName_Learned = context.getString(R.string.dictionary_title_learned)

        dictionaryAll = CardDictionaryModel().apply {
            title = dictionaryName_All
            id = Integer.MAX_VALUE.toString()
        }
        dictionaryLearned = CardDictionaryModel().apply {
            title =dictionaryName_Learned
            id = Integer.MIN_VALUE.toString()
        }
    }

}