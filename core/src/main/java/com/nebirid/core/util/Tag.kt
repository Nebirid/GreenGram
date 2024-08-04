package com.nebirid.core.util

fun Any.TAG(maxLength: Int = 23): String {
    // Get the class name of the object
    val className = this::class.java.simpleName
    // If the class name exceeds the max length, truncate it
    return if (className.length <= maxLength) {
        className
    } else {
        className.substring(0, maxLength)
    }
}