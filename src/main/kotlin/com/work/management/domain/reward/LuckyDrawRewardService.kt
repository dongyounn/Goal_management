package com.work.management.domain.reward

import com.work.management.domain.reward.dto.CreateLuckyDrawRequest
import com.work.management.domain.reward.dto.CreateLuckyDrawResponse
import com.work.management.global.dto.LUCKY_DRAW_NUMBER
import com.work.management.global.dto.getAutoNumber
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LuckyDrawRewardService(
    private val luckyDrawRewardRepository: LuckyDrawRewardRepository
) {
    @Transactional
    fun generateLuckyDrawReward(request: CreateLuckyDrawRequest): CreateLuckyDrawResponse {
        val userId = request.userId
        val randomNumber = LUCKY_DRAW_NUMBER.getAutoNumber().joinToString()
        LuckyDrawReward.ofSetting(randomNumber, userId).also {
            luckyDrawRewardRepository.save(it)
        }
        return CreateLuckyDrawResponse(userId, randomNumber)
    }

    @Transactional(readOnly = true)
    fun getLuckyDrawRewards(userId: Long) = luckyDrawRewardRepository.findByUserId(userId)

    @Transactional(readOnly = true)
    fun getLuckyDrawRewardsExcludeExpired(userId: Long): List<LuckyDrawReward> {
        return luckyDrawRewardRepository.findByUserIdAndExpired(userId)
    }

}