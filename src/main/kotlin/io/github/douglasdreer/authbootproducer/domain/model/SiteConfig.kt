package io.github.douglasdreer.authbootproducer.domain.model

/**
 * Represents the configuration for a specific site from which to extract information.
 *
 * @property id The unique identifier for the site configuration.
 * @property siteName The name of the site.
 * @property emailFrom The expected "from" address in the email.
 * @property emailSubjectContains A string that the email subject must contain.
 * @property extractionRegex The regular expression used to extract the desired information from the email body.
 * @property isActive A flag to indicate if this configuration is currently active.
 */
data class SiteConfig(
    val id: Long,
    val siteName: String,
    val emailFrom: String,
    val emailSubjectContains: String,
    val extractionRegex: String,
    val isActive: Boolean
)
