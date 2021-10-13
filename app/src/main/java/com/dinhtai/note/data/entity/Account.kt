package com.dinhtai.note.data.entity

import com.dinhtai.note.R

interface Account {
    val accountId: String
    val name: String
    val mailAddress: String
    val imageUrl: String?
}

data class AccountInfo(
    override val accountId: String,
    override val name: String,
    override val mailAddress: String,
    override val imageUrl: String?,
    val lastOnlineAt: Long
) : Account

// Dùng để xác định trong group, có  thêm raw
data class User(
    override val accountId: String,
    override val name: String,
    override val mailAddress: String,
    override val imageUrl: String?,
    val roleInGroup: RoleInGroup
) : Account {

    val showRoleInGroup: List<Int>
        get() {
            val read = R.string.role_read
            val write = R.string.role_write
            val admin = R.string.role_admin
            var rs: List<Int>
            when (roleInGroup) {
                RoleInGroup.Lv1 -> rs = listOf(admin, read, write)
                RoleInGroup.Lv2 -> rs = listOf(read, write)
                RoleInGroup.Lv3 -> rs = listOf(write)
            }
            return rs
        }
}

typealias accounts = List<AccountInfo>