package com.dinhtai.note.di

import androidx.fragment.app.Fragment
import com.dinhtai.note.ui.home.HomeFragment
import com.dinhtai.note.ui.noteedit.NoteEditFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FragmentModule {
    @Binds
    abstract fun home(fragment: HomeFragment): Fragment

    @Binds
    abstract fun noteEdit(fragment: NoteEditFragment): Fragment
}