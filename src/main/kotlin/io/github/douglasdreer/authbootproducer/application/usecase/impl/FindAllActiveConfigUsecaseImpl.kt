package io.github.douglasdreer.authbootproducer.application.usecase.impl

import io.github.douglasdreer.authbootproducer.application.port.ConfigRepositoryPort
import io.github.douglasdreer.authbootproducer.application.port.input.query.FindAllActiveSiteConfigQuery
import io.github.douglasdreer.authbootproducer.application.usecase.FindAllActiveConfigUsecase
import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class FindAllActiveConfigUsecaseImpl(
    private val repositoryPort: ConfigRepositoryPort
) : FindAllActiveConfigUsecase {
    override fun execute(query: FindAllActiveSiteConfigQuery): Page<SiteConfig> {
        return repositoryPort.findAllActiveConfigs(
            page = query.page -1,
            pageSize = query.pageSize
        )
    }
}