package inside.langcard.domain.model

import inside.langcard.presentation.Dialog.CardColors

/**
 * Created by Pasha on 10/28/2017.
 */
class CardModel{
    private var _sideType : SideTypes = SideTypes.Front

    private var isChanged: Boolean = false
    private var isNew: Boolean = false
    private var isRemoved: Boolean = false
    private var isLearned: Boolean = false



    val first : CardSideMode = CardSideMode()
    val second : CardSideMode = CardSideMode()

    val sideType : SideTypes get() = _sideType

    fun getInvertOfCurrentSideType():SideTypes{// foo method

        return return SideTypes.Back
    }
    fun getLearningText(type:SideTypes):Array<String>{// foo method
        return emptyArray()  //Array<String>(0,{i->""}) the 2nd way how to create empty array :)
    }
    fun getLanguage(type: SideTypes): String{//foo method

        return ""
    }
    fun getBackground(): CardColors{ //foo method
        return CardColors.Blue
    }


}

class CardSideMode {
    private lateinit var _learningText: String
    public var learningText : String
        get() = _learningText
        set(value) {
            _learningText = value
        }


}