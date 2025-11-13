package io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.mapper

import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model.SiteConfigResponse
import org.springframework.data.domain.Page

fun SiteConfig.toResponse() = SiteConfigResponse(
    id = id,
    siteName = siteName,
    emailFrom = emailFrom,
    emailSubjectContains = emailSubjectContains,
    extractionRegex = extractionRegex,
    isActive = isActive
)



fun List<SiteConfig>.toResponse() = map { it.toResponse() }
fun Page<SiteConfig>.toResponse() = map { it.toResponse() }
