package com.colinwd.kvstore.models

data class KeyValueGetResponse(
        val ok: Boolean,
        val value: String? = null,
        val error: String? = null
)
