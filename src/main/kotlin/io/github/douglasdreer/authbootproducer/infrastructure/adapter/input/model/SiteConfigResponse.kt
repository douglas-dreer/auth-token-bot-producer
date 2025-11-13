package io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model

data class SiteConfigResponse(
    val id: Long,
    val siteName: String,
    val emailFrom: String,
    val emailSubjectContains: String,
    val extractionRegex: String,
    val isActive: Boolean
)
