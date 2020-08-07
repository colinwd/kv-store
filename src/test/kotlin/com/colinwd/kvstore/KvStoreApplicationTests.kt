package com.colinwd.kvstore

import com.colinwd.kvstore.models.StoragePutRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert

@SpringBootTest
class KvStoreApplicationTests(@Autowired val keyValueController: KeyValueController) {

	@Test
	fun contextLoads() {
	}

	@Test
	fun testStorageLifecycle() {
		val storeId = "storeId"
		val key = "key"
		val value = "value"

		keyValueController.createStore(storeId)

		val storagePutRequest = StoragePutRequest(storeId, key, value)
		keyValueController.put(storagePutRequest)

		val response = keyValueController.get(storeId, key)

		Assert.isTrue(response.ok, "Received error response from controller")
		Assert.isTrue(response.value == value, "Mismatched values for key")
	}
}
