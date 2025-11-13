package io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.repository

import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.entity.SiteConfigEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringDataSiteConfigRepository : JpaRepository<SiteConfigEntity, Long> {
    fun findAllByIsActiveTrue(pageable: Pageable): Page<SiteConfig>
}