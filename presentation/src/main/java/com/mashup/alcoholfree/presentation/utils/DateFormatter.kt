package com.mashup.alcoholfree.presentation.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateFormatter {
    fun dateFormat(date: String): String {
        return LocalDateTime
            .parse(date, DateTimeFormatter.ISO_DATE_TIME)
            .atZone(ZoneId.of("Asia/Seoul"))
            .format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
    }
}
