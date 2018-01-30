package inside.langcard.domain.model

/**
 * Created by Pasha on 1/30/2018.
 */
class CardDictionaryModel{
    val isLearned: Boolean = false
    val isAll: Boolean = false

    var title : String
        get() = "Test Title"
        set(value) {}


    val count : Int = 10


}