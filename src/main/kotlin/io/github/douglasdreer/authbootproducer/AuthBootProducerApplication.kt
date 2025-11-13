package io.github.douglasdreer.authbootproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthBootProducerApplication

fun main(args: Array<String>) {
    runApplication<AuthBootProducerApplication>(*args)
}
