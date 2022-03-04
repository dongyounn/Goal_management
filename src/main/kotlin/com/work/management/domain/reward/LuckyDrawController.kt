package com.work.management.domain.reward

import com.work.management.domain.reward.dto.CreateLuckyDrawRequest
import com.work.management.domain.reward.dto.CreateLuckyDrawResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reward")
class LuckyDrawController(
    private val luckyDrawRewardService: LuckyDrawRewardService
) {

    @PostMapping
    fun createLuckyDraw(
        @RequestBody createLuckyDrawRequest: CreateLuckyDrawRequest
    ): CreateLuckyDrawResponse {
        return luckyDrawRewardService.generateLuckyDrawReward(createLuckyDrawRequest)
    }

    @GetMapping("/user/{userId}")
    fun getLuckyDraws(
        @PathVariable userId: Long
    ): List<LuckyDrawReward> {
        return luckyDrawRewardService.getLuckyDrawRewardsExcludeExpired(userId)
    }

}