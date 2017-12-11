package inside.langcard.presentation.addcard

import android.app.Activity
import android.os.Bundle
import android.support.design.R.id.message
import android.support.design.widget.BottomNavigationView
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.ICommutativeElement
import com.svp.infrastructure.mvpvs.view.AppCompatActivityView
import inside.langcard.*
import inside.langcard.R.menu.navigation
import inside.langcard.domain.model.CardModel
import inside.langcard.presentation.ActivityOperationResult
import kotlinx.android.synthetic.main.activity_edit_card.*


class EditCardActivity : AppCompatActivityView<EditCardActivity, EditCardActivity.ViewState, EditCardPresenter>(), ICommutativeElement {

    /*
    * ICommutativeElement
    * */
    override val activity: Activity
        get() = this
    override val operation: ActivityOperationItem
        get() = ActivityOperationResult.AddEditCard



    class ViewState(private val act:EditCardActivity) :
            com.svp.infrastructure.mvpvs.viewstate.ViewState<EditCardActivity>(act) {

        private lateinit var _model : CardModel
        public var model : CardModel
            get() = _model
            set(value: CardModel) {
                _model = value
            }


        override val activity : Activity get() = act
        override fun restore() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun saveState() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun setText(txt: String){
            activity.test_message.text = txt
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //
                presenter.click1()

                 true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                presenter.click2()
                 true
            }
            R.id.navigation_notifications -> {
               //   message.setText(R.string.title_notifications)
                test_message.setText(R.string.title_notifications)
                presenter.click3()
                 true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_card)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

