package com.colinwd.kvstore.models

data class StorageGetRequest(
        val storeId: String,
        val key: Any,
        val value: Any
)
