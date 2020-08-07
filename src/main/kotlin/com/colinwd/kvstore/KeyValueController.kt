package com.colinwd.kvstore

import com.colinwd.kvstore.models.KeyValueGetResponse
import com.colinwd.kvstore.models.KeyValuePutResponse
import com.colinwd.kvstore.models.StorageCreateResponse
import com.colinwd.kvstore.models.StoragePutRequest
import com.colinwd.kvstore.storage.InMemoryStore
import com.colinwd.kvstore.storage.StoreFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class KeyValueController(private val storeFactory: StoreFactory) {

    @GetMapping("/get/{storeId}/{key}")
    public fun get(storeId: String, key: String): KeyValueGetResponse {
        val store = storeFactory.get(storeId)

        return if (store != null) {
            val value = store.get(key)
            KeyValueGetResponse(true, value)
        } else {
            KeyValueGetResponse(false, "Store with id $storeId not found!")
        }
    }

    @PostMapping("/put")
    public fun put(request: StoragePutRequest): KeyValuePutResponse {
        val storeId = request.storeId
        val store = storeFactory.get(storeId)

        return if (store != null) {
            store.put(request.key, request.value)
            KeyValuePutResponse(true)
        } else {
            KeyValuePutResponse(false, "Store with id $storeId not found!")
        }
    }

    @PostMapping("/store/{storeId}")
    public fun createStore(storeId: String): StorageCreateResponse {
        storeFactory.create(storeId, InMemoryStore())
        return StorageCreateResponse(true)
    }
}