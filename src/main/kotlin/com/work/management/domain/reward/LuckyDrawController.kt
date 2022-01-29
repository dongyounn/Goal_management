package com.work.management.domain.reward

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reward")
class LuckyDrawController(
    private val luckyDrawRewardRepository: LuckyDrawRewardRepository
) {

    @GetMapping
    fun test() = luckyDrawRewardRepository.findAll()
}