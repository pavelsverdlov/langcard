package inside.langcard.data.dto

import inside.langcard.data.UUIDBaseDto

/**
 * Created by Pasha on 10/28/2017.
 * LearnCard is the ticket union in group for some list of learning
 * example:
 * Group for learning by 10/10/2015
 * - LearnTicket1
 * - LearnTicket2
 * ...
 */
class LearnCard : UUIDBaseDto(){
    /**
     * 0 - first
     * 1 - second
     */
    var learningSide: Int = 0

    var first: OneSideCard = OneSideCard()
    var second: OneSideCard = OneSideCard()

    var background: Int = 0
    var dictionary: CardDictionary? = null
    var noDictionary: Boolean = false

}