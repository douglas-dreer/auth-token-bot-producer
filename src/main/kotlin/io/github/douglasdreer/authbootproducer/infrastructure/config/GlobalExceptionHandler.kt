package io.github.douglasdreer.authbootproducer.infrastructure.config

import io.github.douglasdreer.authbootproducer.domain.exception.NotFoundSiteConfigException
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundSiteConfigException::class)
    fun handlerNotFoundSiteConfigException(exception: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            message = exception.message ?: "Site config no existente",
            description = exception.message ?: "Site config no existente"
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse)
    }
}