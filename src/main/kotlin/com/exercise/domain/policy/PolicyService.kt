package com.exercise.domain.policy

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PolicyService(
    private val policyRepository: PolicyRepository
) {
    private val log = LoggerFactory.getLogger(this::class.java)


}