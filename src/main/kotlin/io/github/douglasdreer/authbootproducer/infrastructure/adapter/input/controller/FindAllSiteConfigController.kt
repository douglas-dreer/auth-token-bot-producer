package io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.controller

import io.github.douglasdreer.authbootproducer.application.port.input.query.FindAllActiveSiteConfigQuery
import io.github.douglasdreer.authbootproducer.application.usecase.FindAllActiveConfigUsecase
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.mapper.toResponse
import io.github.douglasdreer.authbootproducer.infrastructure.adapter.input.model.SiteConfigResponse
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/site-configs")
class FindAllSiteConfigController(
    private val usecase: FindAllActiveConfigUsecase
) {
    @GetMapping
    fun execute(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "pageSize", defaultValue = "50") pageSize: Int
    ): ResponseEntity<Page<SiteConfigResponse>> {
        val result = usecase.execute(FindAllActiveSiteConfigQuery(page = page, pageSize = pageSize))
        return ResponseEntity.ok(result.toResponse())
    }
}
