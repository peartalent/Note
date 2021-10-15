package com.dinhtai.note.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactoryImpl @Inject internal constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelFactory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown Repo class $modelClass")
        }
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }

    override fun <T : ViewModel> get(activity: FragmentActivity, storeClass: Class<T>): T {
        return ViewModelProvider(activity, this).get(storeClass)
    }

    override fun <T : ViewModel> get(fragment: Fragment, storeClass: Class<T>): T {
        return ViewModelProvider(fragment, this).get(storeClass)
    }
}