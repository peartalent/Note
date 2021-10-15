package com.dinhtai.note.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface ViewModelFactory : ViewModelProvider.Factory {

    operator fun <T : ViewModel> get(activity: FragmentActivity, storeClass: Class<T>): T {
        return ViewModelProvider(activity, this).get(storeClass)
    }

    operator fun <T : ViewModel> get(fragment: Fragment, storeClass: Class<T>): T {
        return ViewModelProvider(fragment, this).get(storeClass)
    }
}
