package com.colinwd.kvstore.storage

import java.util.concurrent.ConcurrentHashMap

class InMemoryStore<K, V> : Store<K, V> {

    private val backingStore = ConcurrentHashMap<K, V>()

    override fun put(key: K, value: V) {
        backingStore[key] = value
    }

    override fun get(key: K): V? {
        return backingStore[key]
    }
}