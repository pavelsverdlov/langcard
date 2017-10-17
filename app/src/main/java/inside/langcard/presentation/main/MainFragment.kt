package inside.langcard.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import inside.langcard.MainActivity
import inside.langcard.databinding.MainFragmentBinding
import inside.langcard.presentation.core.FragmentInActivity

/**
 * Created by Pasha on 10/15/2017.
 */
class MainFragment : FragmentInActivity<MainActivity>(){

    private lateinit var viewDataBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewDataBinding = MainFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = act().obtainViewModel()
        }

        act().fab().setOnClickListener { view ->
            viewDataBinding.viewmodel.addNewCard()
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        }

        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}