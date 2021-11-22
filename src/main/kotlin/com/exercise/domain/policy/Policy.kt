package com.exercise.domain.policy

import com.exercise.global.dto.BaseDomain
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "exercise_policy")
data class ExercisePolicy(
    @Id
    val id: Long? = null,
    val exerciseType: ExerciseType,
    val amount: Int,
    val timesPerWeek: Int,
    val exercisePeriod: Int
) : BaseDomain()

enum class ExerciseType(val type: String) {
    CROSSFIT("All"), WEIGHT_TRAINING("Weight"), RUN("Aerobic")
}