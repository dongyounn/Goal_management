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
    // todo user 관계 양방향 설정 필요? 고민
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