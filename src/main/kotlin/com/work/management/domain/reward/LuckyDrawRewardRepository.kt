package com.work.management.domain.reward

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LuckyDrawRewardRepository : JpaRepository<LuckyDrawReward, Long>