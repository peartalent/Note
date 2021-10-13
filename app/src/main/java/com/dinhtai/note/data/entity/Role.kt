package com.dinhtai.note.data.entity

enum class RoleInGroup {
    Lv1, // người tạo
    Lv2, // khi được thêm có vai trò edit, (mặc định)
    Lv3, // chỉ có quyền đọc, có quyền thêm người
}

val roleInGroupDefault = RoleInGroup.Lv2
val roleInGroupCreator = RoleInGroup.Lv1