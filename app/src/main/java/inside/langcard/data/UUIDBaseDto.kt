package inside.langcard.data

import java.util.*

/**
 * Created by Pasha on 10/28/2017.
 */
open class UUIDBaseDto(val created: Date = Date()){
    val id get() = _id
    private var _id : String = generateId()

    fun generateId() : String =
       java.util.UUID.randomUUID().let {
           _id = this.toString()
           return _id
       }

}