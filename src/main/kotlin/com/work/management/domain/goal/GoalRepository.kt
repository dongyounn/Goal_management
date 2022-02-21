package com.work.management.domain.goal

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoalRepository : JpaRepository<Goal, Long> {
    fun findByReaderUserId(userId: Long): List<Goal>
}

