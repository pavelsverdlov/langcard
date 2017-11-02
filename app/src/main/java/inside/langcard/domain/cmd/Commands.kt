package inside.langcard.domain.cmd

import inside.langcard.data.dto.LearnCard
import java.util.logging.Logger

/**
 * Created by Pasha on 10/15/2017.
 */

class AddNewCardCommandData(val learnCard: LearnCard): ICommandData {

}
class AddNewCardCommand : ICommand{
    fun execute(data: AddNewCardCommandData){

    }
}