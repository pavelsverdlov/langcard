package inside.langcard

import android.app.Application
import com.svp.infrastructure.mvpvs.PresenterContainer
import com.svp.infrastructure.mvpvs.Registrator
import com.svp.infrastructure.mvpvs.ViewStateContainer
import com.svp.infrastructure.mvpvs.presenter.IPresenter
import com.svp.infrastructure.mvpvs.view.IActivityView
import com.svp.infrastructure.mvpvs.viewstate.IViewState
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

        //init presenter / viewstate

        Registrator.register(MainActivity::class.java,
           object: PresenterContainer.IPresenterCreator {
            override fun create(): IPresenter = MainPresenter(UUID.randomUUID())
        }, object: ViewStateContainer.IViewStateCreator {
            override fun <V : IActivityView> create(view: V): IViewState = MainActivity.ViewState(view as MainActivity)
        })


        super.onCreate()
    }
}