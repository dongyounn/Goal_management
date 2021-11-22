package com.exercise.domain.policy

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PolicyRepository : JpaRepository<ExercisePolicy, Long> {

}