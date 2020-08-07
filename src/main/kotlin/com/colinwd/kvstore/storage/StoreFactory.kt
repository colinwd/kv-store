package com.colinwd.kvstore.storage

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class StoreFactory {

    private val storeMap = ConcurrentHashMap<String, Store>()

    fun get(storeId: String): Store? {
        return storeMap[storeId]
    }

    fun create(storeId: String, store: Store) {
        if (!storeMap.containsKey(storeId)) {
            storeMap[storeId] = store
        }
    }

    fun update(storeId: String, store: Store) {
        storeMap[storeId] = store
    }
}