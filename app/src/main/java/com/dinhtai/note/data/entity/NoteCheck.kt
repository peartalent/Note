package com.dinhtai.note.data.entity

import android.graphics.Color

data class NoteCheck(
    override val noteId: Int,
    override val title: String,
    override val lastEditAt: Long,
    val contents : List<ItemCheck>,
    override val colorBg: Int = Color.YELLOW
) : Note

data class ItemCheck(val id : Int, val content: String, val isCheck: Boolean = false)