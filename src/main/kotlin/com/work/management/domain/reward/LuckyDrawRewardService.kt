package com.work.management.domain.reward

import com.work.management.global.dto.LUCKY_DRAW_NUMBER
import com.work.management.global.dto.getAutoNumber
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LuckyDrawRewardService(
    private val luckyDrawRewardRepository: LuckyDrawRewardRepository
) {
    @Transactional
    fun generateLuckyDrawReward(userId: Long): String {
        val randomNumber = LUCKY_DRAW_NUMBER.getAutoNumber().joinToString()
        LuckyDrawReward.ofSetting(randomNumber, userId).also {
            luckyDrawRewardRepository.save(it)
        }
        return randomNumber
    }

    @Transactional(readOnly = true)
    fun getLuckyDrawRewards(userId: Long) = luckyDrawRewardRepository.findByUserId(userId)


}