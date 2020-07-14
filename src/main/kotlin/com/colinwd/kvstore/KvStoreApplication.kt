package com.colinwd.kvstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KvStoreApplication

fun main(args: Array<String>) {
	runApplication<KvStoreApplication>(*args)
}
