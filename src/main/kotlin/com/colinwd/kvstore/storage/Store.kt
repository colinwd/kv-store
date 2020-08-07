package com.colinwd.kvstore.storage

interface Store<K, V> {
    fun put(key: K, value: V)
    fun get(key: K): V?
}