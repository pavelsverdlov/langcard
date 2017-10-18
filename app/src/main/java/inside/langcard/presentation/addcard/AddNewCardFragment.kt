package inside.langcard.presentation.addcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import inside.langcard.MainActivity
import inside.langcard.databinding.MainFragmentBinding
import inside.langcard.presentation.core.FragmentInActivity
import inside.langcard.presentation.main.MainFragment

/**
 * Created by Maxim on 10/18/2017.
 */
class AddNewCardFragment : FragmentInActivity<MainActivity>(){
    private lateinit var viewDataBinding : MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewDataBinding = MainFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = act().obtainViewModel()
        }

        act().fab().setOnClickListener{
            view -> viewDataBinding.viewmodel.addNewCard()
        }

        setHasOptionsMenu(true)
        return viewDataBinding.root

    }
    companion object {
        fun newInstance() = MainFragment()
    }
}