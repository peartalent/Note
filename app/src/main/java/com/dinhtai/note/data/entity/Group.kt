package com.dinhtai.note.data.entity

interface Group {
    val groupId: String
    val name: String
    val imageUrl: String?
    val colorBg: Int
    val createAt: Long
}

