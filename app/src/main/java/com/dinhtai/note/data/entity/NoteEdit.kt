package com.dinhtai.note.data.entity

import android.graphics.Color

data class NoteEdit(
    override val noteId: Int,
    override val title: String,
    override val lastEditAt: Long,
    override val colorBg: Int = Color.YELLOW,
    val content:String =""
) : Note