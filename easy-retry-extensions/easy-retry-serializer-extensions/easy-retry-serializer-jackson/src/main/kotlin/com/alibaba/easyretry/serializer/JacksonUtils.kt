package com.alibaba.easyretry.serializer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object JacksonUtils {

    private val mapper = jacksonObjectMapper()

    fun serialize(any: Any): String {
        return mapper.writeValueAsString(any)
    }

    fun <T> deserialize(string: String, valueType: Class<T>): T {
        return mapper.readValue(string, valueType)
    }
}