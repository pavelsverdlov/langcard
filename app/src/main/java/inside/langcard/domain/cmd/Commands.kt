package inside.langcard.domain.cmd

import android.database.Cursor
import inside.langcard.data.CardRepository
import inside.langcard.data.dto.CardDictionary
import inside.langcard.data.dto.LearnCard
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteDatabase


/**
 * Created by Pasha on 10/15/2017.
 */

class AddNewCardCommandData(val learnCard: LearnCard): ICommandData {

}
class AddNewCardCommand : ICommand{
    fun execute(data: AddNewCardCommandData){

    }
}

class GetCardsCommandData(val dictionary: CardDictionary): ICommandData {

}
class GetCardsCommand : ICommand{
    fun execute(repo : CardRepository) : List<LearnCard>{
        return get<LearnCard>(repo, listOf<String>("")){

            listOf<LearnCard>()
        }
    }

    //todo refactor the following methods to Kotlin style
    private fun execute(query: List<String>) {
        var db: SQLiteDatabase? = null
        try {
            val queries = query
            for (i in queries.indices) {
                db!!.execSQL(queries[i])
            }
        } finally {
            if (db != null) {
                db.close()
            }
        }
    }
    private fun <T> get(repo: CardRepository, query: List<String>, parse: (Cursor)-> List<T>): List<T> {
        var db: SQLiteDatabase? = null
        var c: Cursor? = null
        val s: String = try {
            val queries = query
            if (queries.size != 1) {
                throw InternalError("get - queries.length != 1")
            }
            val q = queries[0]
            //   Log.d("get", q);
            c = db!!.rawQuery(q, null)
            return parse(c)
        } catch (sqle: SQLiteException) {
            sqle.toString()
            // Log.e("get",sqle.getMessage(),sqle);
        } finally {
            c!!.close()
        }
        return listOf()
    }
}
