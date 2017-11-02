package inside.langcard.domain.model

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

}

class CardSideMode {
    private lateinit var _learningText: String
    public var learningText : String
        get() = _learningText
        set(value) {
            _learningText = value
        }


}