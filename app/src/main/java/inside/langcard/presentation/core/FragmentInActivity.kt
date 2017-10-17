package inside.langcard.presentation.core

import android.app.Activity
import android.support.v4.app.Fragment

/**
 * Created by Pasha on 10/16/2017.
 */
abstract class FragmentInActivity<TActivity : Activity>() : Fragment(){
    fun act() = activity as TActivity
}