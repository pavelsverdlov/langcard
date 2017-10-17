package inside.langcard.presentation.core

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import inside.langcard.presentation.Commutator
import inside.langcard.presentation.ViewModelFactory

/**
 * Created by Pasha on 10/15/2017.
 */
abstract class LifecycleAppCompatActivity : AppCompatActivity(), LifecycleOwner {
    private val registry = LifecycleRegistry(this)
    protected val commutator = Commutator(this)

    override fun getLifecycle(): LifecycleRegistry = registry

    protected fun <T : ViewModel> obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

}