package io.github.douglasdreer.authbootproducer.domain.extention

import io.github.douglasdreer.authbootproducer.domain.model.SiteConfig

/**
 * Extracts a token from the given email body using the regex defined in the SiteConfig.
 *
 * @param emailBody The content of the email to extract the token from.
 * @return The extracted token, or null if no token is found or if the regex is invalid.
 */
fun SiteConfig.extractTokenFrom(emailBody: String): String? {
    val regex = this.compileRegex() ?: return null
    val match = regex.findMatch(emailBody) ?: return null
    return match.extractGroup()
}

/**
 * Compiles the regex string from the SiteConfig into a Regex object.
 * Handles potential exceptions during compilation.
 *
 * @return A Regex object, or null if the regex string is invalid.
 */
private fun SiteConfig.compileRegex(): Regex? {
    return try {
        Regex(this.extractionRegex, RegexOption.DOT_MATCHES_ALL)
    } catch (e: Exception) {
        println("!! ERRO DE DOMÍNIO: Regex inválida para o site ${this.siteName}: ${this.extractionRegex}")
        null
    }
}

/**
 * Finds the first match of the regex in the given email body.
 *
 * @param emailBody The string to search for a match.
 * @return A MatchResult if a match is found, otherwise null.
 */
private fun Regex.findMatch(emailBody: String): MatchResult? {
    return this.find(emailBody)
}

/**
 * Extracts the first captured group from the MatchResult.
 *
 * @return The trimmed string of the first group, or null if no groups are captured.
 */
private fun MatchResult.extractGroup(): String? {
    return if (this.groupValues.size > 1) {
        this.groupValues[1].trim()
    } else {
        null
    }
}
