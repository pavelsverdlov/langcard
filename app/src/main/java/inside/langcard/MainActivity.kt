package inside.langcard

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.ICommutativeElement
import com.svp.infrastructure.mvpvs.view.AppCompatActivityView
import inside.langcard.domain.model.CardModel
import inside.langcard.presentation.ActivityOperationResult
import inside.langcard.presentation.ContentViewer
import inside.langcard.presentation.main.MainPresenter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivityView<MainActivity, MainActivity.ViewState, MainPresenter>(),
        NavigationView.OnNavigationItemSelectedListener, ICommutativeElement {

    /*
    * ICommutativeElement
    * */
    override val activity: Activity
        get() = this
    override val operation: ActivityOperationItem
        get() = ActivityOperationResult.Main

    /*
    *
    * */
    class ViewState(private val act:MainActivity) :
            com.svp.infrastructure.mvpvs.viewstate.ViewState<MainActivity>(act) {

        override val activity : Activity get() = act
        override fun restore() {
        }
        override fun saveState() {
        }
    }

    companion object {

    }

    private lateinit var viewer : ContentViewer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            presenter.addNewCard()
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        viewer = ContentViewer(this)
        viewer.onCreateView(presenter.getCards(),2, object  : ContentViewer.OnCardListener{
            override fun onClick(card: CardModel){
                presenter.editCard(card)
            }
        })
    }



    /*
    *
    * */




    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
