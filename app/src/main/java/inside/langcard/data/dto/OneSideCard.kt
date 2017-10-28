package inside.langcard.data.dto

import inside.langcard.data.UUIDBaseDto
import java.util.*

/**
 * Created by Pasha on 10/28/2017.
 */
class OneSideCard : UUIDBaseDto() {
    var learningText: String = ""

    var language: Int = 0
    var correctCount: Int = 0
    var incorrectCount: Int = 0

    var lang: CardLanguage? = null
}