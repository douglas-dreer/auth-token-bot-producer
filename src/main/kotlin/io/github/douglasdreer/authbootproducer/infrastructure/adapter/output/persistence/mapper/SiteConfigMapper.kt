package io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.mapper

import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.entity.SiteConfigEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

fun SiteConfigEntity.toDomain() = SiteConfig(
    id = id,
    siteName = siteName,
    emailFrom = emailFrom,
    emailSubjectContains = emailSubjectContains,
    extractionRegex = extractionRegex,
    isActive = isActive
)

fun SiteConfig.toEntity() = SiteConfigEntity(
    id = id,
    siteName = siteName,
    emailFrom = emailFrom,
    emailSubjectContains = emailSubjectContains,
    extractionRegex = extractionRegex,
    isActive = isActive
)

fun List<SiteConfigEntity>.toDomain() = this.map { it.toDomain() }

fun Page<SiteConfigEntity>.toDomain() = PageImpl(
    content.toDomain(),
    pageable,
    totalElements
)
