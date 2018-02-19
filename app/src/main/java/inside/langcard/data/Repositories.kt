package inside.langcard.data

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import inside.langcard.R
import inside.langcard.data.dto.LearnCard
import kotlinx.android.synthetic.main.activity_edit_card.*
import java.text.SimpleDateFormat

/**
 * Created by Pasha on 10/15/2017.
 */

abstract class  BaseRepository<TEntity : UUIDBaseDto>{
    private val dbVersion = 2
    val dbName = "db_languagetickets"
    protected val dbLearnTicketsTableName = "tb_learntickets"
    protected val dbSideTicketsTableName = "tb_sidetickets"
    //  private static final String dbLearnGroupsTableName = "tb_learngroups";
    protected val dbDictionariesTableName = "tb_dictionaries"
    protected val dbTicketDictionariesTableName = "tb_ticket_dictionaries"
    protected val dbTicketsLearnedTableName = "tb_tickets_learned"
    protected val dbLanguagesTableName = "tb_languages"


    abstract fun add(add:TEntity)
    abstract fun remove(add:TEntity)
    //abstract fun find()
    protected fun getDateFormatter(): SimpleDateFormat {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }
}
class CardRepository(private val storage : DatabaseStorage) : BaseRepository<LearnCard>(){

    private val db: SQLiteDatabase = open()

    fun open(): SQLiteDatabase {
        //todo: can be exception if path is incorrect
        return SQLiteDatabase.openOrCreateDatabase(storage.path, null)
    }
    fun close(){
        db.close()
    }

    override fun remove(add: LearnCard) {

    }

    override fun add(add: LearnCard) {
        val insertSide = "INSERT INTO $dbSideTicketsTableName (id, created, learningText, language, correctCount, incorrectCount) VALUES ";
        add.first.apply {
            val dcreated = getDateFormatter().format(created)
            val q = "$insertSide ('$id', '$dcreated', '$learningText', $language, $correctCount, $incorrectCount);"
        }
    }

    fun get(query : String): Cursor {
        return db.rawQuery(query, null)
    }

}
/*
class DictornaryRepository : BaseRepository(){

}
class LangRepository : BaseRepository(){

}
*/
