package com.dinhtai.note.data.entity

interface Note {
    val noteId: Int
    val title: String
    val lastEditAt: Long
    val colorBg: Int
}
