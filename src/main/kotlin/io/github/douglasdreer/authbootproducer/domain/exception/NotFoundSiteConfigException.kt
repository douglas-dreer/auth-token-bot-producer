package io.github.douglasdreer.authbootproducer.domain.exception

import org.springframework.http.HttpStatus

class NotFoundSiteConfigException(siteConfigId: Int) :
    BusinessException("Not found Site config", HttpStatus.NOT_FOUND)