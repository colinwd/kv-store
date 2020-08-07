package com.colinwd.kvstore.models

data class StoragePutRequest(
        val storeId: String,
        val key: String,
        val value: String
)
