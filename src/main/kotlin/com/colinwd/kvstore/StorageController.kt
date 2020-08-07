package com.colinwd.kvstore

import com.colinwd.kvstore.models.StorageGetRequest
import com.colinwd.kvstore.models.StorageGetResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StorageController {

    @GetMapping("/get")
    fun get(request: StorageGetRequest): StorageGetResponse {
        TODO("not yet implemented")
    }
}