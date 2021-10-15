package com.dinhtai.note.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinhtai.note.data.entity.NoteEdit
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(): ViewModel() {
    init {
        setNoteEdits()
    }

    private val _noteEdits = MutableLiveData<List<NoteEdit>>()
    val noteEdits: LiveData<List<NoteEdit>>
        get() = _noteEdits

    fun setNoteEdits() {
        val note = NoteEdit(
            noteId = 1,
            title = "Xin chaof tai",
            lastEditAt = Date().time,
            content = "Moojt con"
        )
        val note1 = NoteEdit(
            noteId = 1,
            title = "Xin chaof tai",
            lastEditAt = Date().time,
            content = "Nếu bạn muốn Item được chọn hiển thị\n\n\n hiệu ứng khi click vào thì bạn cần chỉnh sửa trong android:background của (he root layout for the row) thành ?android:attr/selectableItemBackground"
        )
        val notes = mutableListOf(note, note1, note1, note, note1)
        _noteEdits.value = notes
    }
}