package inside.langcard.domain.model

/**
 * Created by Pasha on 1/30/2018.
 */
class CardDictionaryModel{
    val isLearned: Boolean = false
    val isAll: Boolean = false

    private var _title: String = "Test Title"
    var title : String
        get() = _title
        set(value) {_title = value }

    private var _id: String = "id"
    var id : String
        get() = _id
        set(value) {_id = value }


    val count : Int = 10


}