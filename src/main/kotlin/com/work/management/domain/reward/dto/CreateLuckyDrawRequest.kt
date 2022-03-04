package com.work.management.domain.reward.dto

data class CreateLuckyDrawRequest(
    val userId: Long
)

data class CreateLuckyDrawResponse(
    val userId: Long,
    val luckyDrawNumber: String
)