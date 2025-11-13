package io.github.douglasdreer.authbootproducer.application.port

import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import org.springframework.data.domain.Page

interface ConfigRepositoryPort {
    fun findAllActiveConfigs(page: Int, pageSize: Int): Page<SiteConfig>
}