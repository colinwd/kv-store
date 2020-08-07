package com.colinwd.kvstore.models

data class KeyValuePutResponse(
        val ok: Boolean,
        val error: String? = null
)
