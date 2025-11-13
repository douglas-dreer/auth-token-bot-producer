package io.github.douglasdreer.authbootproducer.infrastructure.adapter

import io.github.douglasdreer.authbootproducer.application.port.ConfigRepositoryPort
import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.repository.SpringDataSiteConfigRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class H2SiteConfigRepositoryAdapter(
    private val repository: SpringDataSiteConfigRepository,
) : ConfigRepositoryPort {
    override fun findAllActiveConfigs(page: Int, pageSize: Int): Page<SiteConfig> {
        val pageRequest = PageRequest.of(page, pageSize)
        return repository.findAllByIsActiveTrue(pageRequest)
    }
}