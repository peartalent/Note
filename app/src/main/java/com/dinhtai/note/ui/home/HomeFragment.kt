package com.dinhtai.note.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dinhtai.note.common.ViewModelFactory
import com.dinhtai.note.databinding.FragmentHomeBinding
import com.dinhtai.note.ui.common.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment()  {

    lateinit var binding: FragmentHomeBinding
    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels{factory}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater, container, false).let {
            binding = it
            it.lifecycleOwner = viewLifecycleOwner
            it.root
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvContent.apply {
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = NoteAdapter({
                HomeFragmentDirections.actionHomeFragmentToNoteEditFragment(it)
            })
        }
        viewModel.setNoteEdits()
        viewModel.noteEdits.observe(viewLifecycleOwner){
            (binding.rvContent.adapter as NoteAdapter).setItemList(it)
        }

    }
}