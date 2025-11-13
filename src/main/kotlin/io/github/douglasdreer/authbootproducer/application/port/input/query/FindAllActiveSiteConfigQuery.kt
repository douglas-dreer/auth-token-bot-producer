package io.github.douglasdreer.authbootproducer.application.port.input.query

data class FindAllActiveSiteConfigQuery(
    val page: Int,
    val pageSize: Int
)
