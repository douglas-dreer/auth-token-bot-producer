package io.github.douglasdreer.authbootproducer.infrastructure.adapter.output.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "site_config")
data class SiteConfigEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val siteName: String,
    val emailFrom: String,
    val emailSubjectContains: String,
    val extractionRegex: String,
    val isActive: Boolean
)
