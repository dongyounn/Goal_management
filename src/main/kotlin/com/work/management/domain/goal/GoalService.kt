package com.work.management.domain.goal

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GoalService(
    private val goalRepository: GoalRepository
) {

    fun createGoal(request: GoalCreateRequest) {

    }


}