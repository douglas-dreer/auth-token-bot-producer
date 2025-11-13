package io.github.douglasdreer.authbootproducer.application.usecase

import io.github.douglasdreer.authbootproducer.application.port.input.query.FindAllActiveSiteConfigQuery
import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import org.springframework.data.domain.Page

interface FindAllActiveConfigUsecase {
    fun execute(query: FindAllActiveSiteConfigQuery): Page<SiteConfig>
}