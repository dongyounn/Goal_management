package com.exercise.domain.policy

import com.exercise.global.dto.BaseDomain
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "exercise_policy")
data class ExercisePolicy(
    @Id
    val id: Long? = null,
    @Enumerated(EnumType.STRING)
    val countType: CountTypeEnum,
    val yearPerAmount: Long,
    val timePerAmount: Int,
    @Enumerated(EnumType.STRING)
    val ConsultationPeriod: ConsultationPeriodEnum,
    ) : BaseDomain()

enum class CountTypeEnum(val payable: Boolean) {
    FULL(true), NOT_FULL(false), TIME(false)
}

enum class ConsultationPeriodEnum {
    YEAR, MONTH, HALF_YEAR
}