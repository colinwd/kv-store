package com.colinwd.kvstore.storage

import java.util.concurrent.ConcurrentHashMap

class InMemoryStore : Store {

    private val backingStore = ConcurrentHashMap<String, String>()

    override fun put(key: String, value: String) {
        backingStore[key] = value
    }

    override fun get(key: String): String? {
        return backingStore[key]
    }
}