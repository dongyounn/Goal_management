package com.work.management.domain.reward

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LuckyDrawRewardRepository : JpaRepository<LuckyDrawReward, Long> {
    fun findByUserId(userId: Long): List<LuckyDrawReward>
    fun findByUserIdAndExpired(userId: Long, expired: Boolean = false): List<LuckyDrawReward>
}