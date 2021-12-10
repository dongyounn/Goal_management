package com.work.management.global.config.health

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
@ConfigurationProperties(prefix = "info")
data class HealthInfoProperties(
    var version: String = "",
    var git: GitInfo = GitInfo()
)

data class GitInfo(
    val hash: String = "",
    val buildDate: LocalDateTime = LocalDateTime.now()
)