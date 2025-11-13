package io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.mapper

import io.github.douglasdreer.authbootproducer.domain.model.Error
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model.ErrorResponse
import java.time.LocalDateTime

fun Error.toResponse() = ErrorResponse(
    status = this.status,
    message = this.message,
    description = this.description,
    details = this.details,
    timestamp = this.timestamp ?: LocalDateTime.now(),
)