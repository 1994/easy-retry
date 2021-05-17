@file:JvmName("RetryUtils")
@file:JvmMultifileClass

package com.alibaba.easyretry.common.util

import java.lang.reflect.Method

fun isEmpty(str: String?): Boolean {
    return !isNotEmpty(str)
}

fun isNotEmpty(str: String?): Boolean {
    return str?.isNotEmpty() == true;
}

fun <E> collectionIsNotEmpty(collection: Collection<E>?): Boolean {
    return collection?.isNullOrEmpty() == false;
}

fun <K, V> mapIsNotEmpty(map: Map<K, V>?): Boolean {
    return map?.isNullOrEmpty() == false;
}

fun findMethod(methodName: String, clazz: Class<*>, vararg params: Class<*>): Method {
//    fixme superclass
    return clazz.getDeclaredMethod(methodName, *params);
}

