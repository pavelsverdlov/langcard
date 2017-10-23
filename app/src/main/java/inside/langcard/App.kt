package inside.langcard

import android.app.Application
import com.svp.infrastructure.mvpvs.PresenterContainer
import com.svp.infrastructure.mvpvs.Registrator
import com.svp.infrastructure.mvpvs.ViewStateContainer
import com.svp.infrastructure.mvpvs.commutate.ActivityCommutator
import com.svp.infrastructure.mvpvs.presenter.IPresenter
import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.viewstate.IViewState
import inside.langcard.presentation.ActivityOperationResult
import inside.langcard.presentation.addcard.EditCardActivity
import inside.langcard.presentation.addcard.EditCardPresenter
import inside.langcard.presentation.main.MainPresenter
import java.util.*

/**
 * Created by Pasha on 10/22/2017.
 */
class App : Application(){
    init {
        //Thread.setDefaultUncaughtExceptionHandler()
    }

    override fun onCreate() {

        ActivityCommutator.register(ActivityOperationResult.Main, MainActivity::class.java)
        ActivityCommutator.register(ActivityOperationResult.AddEditCard, EditCardActivity::class.java)

        //init presenter / viewstate

        Registrator.register(MainActivity::class.java,
           object: PresenterContainer.IPresenterCreator {
            override fun create(): IPresenter = MainPresenter(UUID.randomUUID())
        }, object: ViewStateContainer.IViewStateCreator {
            override fun <V : IActivityView> create(view: V): IViewState = MainActivity.ViewState(view as MainActivity)
        })

        Registrator.register(EditCardActivity::class.java,
                object: PresenterContainer.IPresenterCreator {
                    override fun create(): IPresenter = EditCardPresenter(UUID.randomUUID())
                }, object: ViewStateContainer.IViewStateCreator {
            override fun <V : IActivityView> create(view: V): IViewState = EditCardActivity.ViewState(view as EditCardActivity)
        })


        super.onCreate()
    }
}