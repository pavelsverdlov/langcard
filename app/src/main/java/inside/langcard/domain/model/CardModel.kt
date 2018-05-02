package inside.langcard.domain.model

import android.os.Parcel
import android.os.Parcelable
import inside.langcard.presentation.Dialog.CardColors
import com.svp.infrastructure.common.StringHelper
import java.util.*


/**
 * Created by Pasha on 10/28/2017.
 *
 * id - identifier from database
 */
class CardModel(val id :String) {
    private var isChanged: Boolean = false
    private var isNew: Boolean = false
    private var isRemoved: Boolean = false
    private var isLearned: Boolean = false



    val first : CardSideMode = CardSideMode(SideTypes.Front,"Front-" + java.util.UUID.randomUUID().toString().substring(0,5),CardLanguageModel())
    val second : CardSideMode = CardSideMode(SideTypes.Back,"Back-"+ java.util.UUID.randomUUID().toString().substring(0,5),CardLanguageModel())

    val currentSide : CardSideMode = first
    val sideType : SideTypes get() = currentSide.side


    fun getDisplayLearningText(): Array<String> {
        return StringHelper.splitByLineSeparator(currentSide.learningText)
    }
    fun getInvertOfCurrentSideType():SideTypes{
        return when(currentSide.side){
            SideTypes.Back ->  SideTypes.Front
            SideTypes.Front ->  SideTypes.Back
        }
    }
    fun getLearningText(type:SideTypes): String{
        return mutableListOf(first, second).first{x -> x.side == type}.learningText
    }
    fun getLanguage(type: SideTypes): CardLanguageModel{
        return mutableListOf(first, second).first{x -> x.side == type}.language
    }
    fun getBackground(): CardColors{ //foo method
        return CardColors.Blue
    }
    fun turnOver(){

    }


}

class CardSideMode(private var _side : SideTypes, private var _learningText : String, private var _language: CardLanguageModel) {
    //private lateinit var  _language: CardLanguageModel
   // private lateinit var  _side: SideTypes
   // private lateinit var _learningText: String

    var language: CardLanguageModel
        get() =  _language
        set(value) { _language = value }

    var side: SideTypes
        get() =  _side
        set(value) { _side = value }


    var learningText : String
        get() = _learningText
        set(value) {
            _learningText = value
        }


}