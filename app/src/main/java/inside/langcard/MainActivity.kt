package inside.langcard

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.svp.infrastructure.mvpvs.commutate.ActivityOperationItem
import com.svp.infrastructure.mvpvs.commutate.ICommutativeElement
import com.svp.infrastructure.mvpvs.view.AppCompatActivityView
import inside.langcard.R
import inside.langcard.presentation.ActivityOperationResult
import inside.langcard.presentation.main.MainPresenter
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.R.attr.x
import android.graphics.Point
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.content_main.*


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


    }

    fun setColumnCount(columns : Int){
        val halfScreenWidth = getScreenWidth() / columns
        val root = rootLayout
        val layouts = arrayOfNulls<LinearLayout>(columns)
        for (i in 0 until columns) {
            layouts[i] = createLinearLayout(root, i, halfScreenWidth)
        }
    }

    private fun getScreenSize(): Point {
        val size = Point()
        activity.windowManager.defaultDisplay.getSize(size)
        return size
    }

    private fun getScreenWidth(): Int {
        return getScreenSize().x
    }

    private fun createLinearLayout(root: GridLayout, index: Int, width: Int): LinearLayout {
        val col = LinearLayout(layoutInflater.context)
        col.orientation = LinearLayout.VERTICAL
        col.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val param = GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(index))
        param.width = width
        root.addView(col, param)

        return col
    }


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
