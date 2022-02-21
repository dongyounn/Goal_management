package com.work.management.domain.goal

import com.fasterxml.jackson.annotation.JsonFormat
import com.work.management.global.dto.BaseDomain
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "goal")
@Entity
data class Goal(
    val readerUserId: Long,
    val maximumParticipants: Int,
    val minimumParticipants: Int,
    val currentParticipants: Int,
    val goalName: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    @Enumerated(EnumType.STRING)
    val goalStatus: GoalStatusEnum
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    companion object {
        fun of(request: GoalCreateRequest): Goal {
            return Goal(
                request.userId,
                0,
                0,
                0,
                request.goalName,
                request.startDate,
                request.endDate,
                GoalStatusEnum.READY
            )
        }
    }
}


data class GoalCreateRequest(
    val userId: Long,
    val goalName: String,
    @JsonFormat(pattern = "yyyyMMdd")
    val startDate: LocalDateTime,
    @JsonFormat(pattern = "yyyyMMdd")
    val endDate: LocalDateTime
)

enum class GoalStatusEnum {
    READY, ACTIVE, TERMINATED, END
}