package io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model

import java.time.LocalDateTime

data class ErrorResponse(
    val status: Int,
    val message: String,
    val description: String,
    val details: Map<String, Any?> = emptyMap(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
)
