package com.dinhtai.note.di

import androidx.lifecycle.ViewModel
import com.dinhtai.note.common.ViewModelFactory
import com.dinhtai.note.common.ViewModelFactoryImpl
import com.dinhtai.note.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {
    @Binds
    abstract fun factory(factory: ViewModelFactoryImpl): ViewModelFactory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun home(vm: HomeViewModel): ViewModel
}