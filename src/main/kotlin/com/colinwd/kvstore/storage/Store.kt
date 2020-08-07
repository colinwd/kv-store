package com.colinwd.kvstore.storage

interface Store {
    fun put(key: String, value: String)
    fun get(key: String): String?
}