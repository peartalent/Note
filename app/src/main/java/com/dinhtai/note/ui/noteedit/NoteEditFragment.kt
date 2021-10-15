package com.dinhtai.note.ui.noteedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dinhtai.note.data.entity.NoteEdit
import com.dinhtai.note.databinding.FragmentHomeBinding
import com.dinhtai.note.databinding.FragmentNoteEditBinding
import com.dinhtai.note.ui.common.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteEditFragment() : Fragment() {

    lateinit var binding: FragmentNoteEditBinding
    private val args: NoteEditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNoteEditBinding.inflate(inflater, container, false).let {
            binding = it
            binding.note = args.note
            it.lifecycleOwner = viewLifecycleOwner
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}