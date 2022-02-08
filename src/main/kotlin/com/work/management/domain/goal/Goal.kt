package com.work.management.domain.goal

import com.work.management.global.dto.BaseDomain
import java.time.LocalDateTime
import javax.persistence.Entity
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
    val goalName: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
}