package com.alibaba.easyretry.serializer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class JacksonUtilsTest {

    @Test
    fun serialize() {
        val test = "haha"
        val serialize = JacksonUtils.serialize(test)
        assertEquals("\"haha\"", serialize)
    }
}
