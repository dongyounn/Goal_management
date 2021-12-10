package com.work.management.global.config

import com.work.management.global.config.health.HealthInfoProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class ApplicationHealthIndicator(
    private val healthInfoProperties: HealthInfoProperties
) : HealthIndicator {

    private val log = LoggerFactory.getLogger(this::class.java)

    /*
    * vm option
    *  -Dspring.config.location=classpath:/build-info.properties,classpath:/application.yml,claspath:/logback.xml
    * */
    @PostConstruct
    fun init() {
        log.info("version: {}", healthInfoProperties.version)
        log.info("hash: {}", healthInfoProperties.git.hash)
        log.info("date: {}", healthInfoProperties.git.buildDate)
    }

    override fun health(): Health {
        return Health.up()
            .withDetail("version", healthInfoProperties.version)
            .withDetail("hash", healthInfoProperties.git.hash)
            .withDetail("build-date", healthInfoProperties.git.buildDate)
            .build()
    }
}