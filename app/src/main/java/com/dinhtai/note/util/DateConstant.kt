package com.dinhtai.note.util

import java.text.SimpleDateFormat
import java.util.*

object DateConstant {
    // DateFormat
    const val DATE_FORMAT_OF_PHOTO_SHOOTING_AT = "yyyy.M.d (E)"
    const val DATE_TIME_FORMAT_OF_PHOTO_SHOOTING_AT = "yyyy.M.d (E) HH:mm"
    const val DATE_FORMAT_OF_KOKUBAN_HEADER_LABEL = "yyyy.M.d (E)"
    const val DATE_TIME_FORMAT_OF_KOKUBAN_HEADER_LABEL = "yyyy.M.d (E) HH:mm"

    /**
     * yyyy/MM/dd HH:mm
     * @param time nullのときは現在
     */
    @JvmStatic
    fun getDateFormatVn(time: Long?): String {
        return dateFormatVn.format(if (time == null) Date() else Date(time))
    }
    private val dateFormatVn = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale("vi", "VN"))
}