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

@Table(name = "goal_participants")
@Entity
data class GoalParticipants(
    val goalId: Long,
    val participantUserId: Long,
    @Enumerated(EnumType.STRING)
    val status: GoalStatus,
    val penaltyCount: Int? = 0,
    val achievementRate: Double
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null


}

enum class GoalStatus {
    ACTIVE, TERMINATED, PENALTY, READY
}
