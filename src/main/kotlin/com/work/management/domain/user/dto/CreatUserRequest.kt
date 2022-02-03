package com.work.management.domain.user.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class CreatUserRequest(
    val name: String,
    val phoneNumber: String,
    val address: String,
    val detailAddress: String,
    @JsonFormat(pattern = "yyyyMMdd")
    val dayOfBirth: LocalDate,
    val gender: GenderEnum
)

data class UpdateUserRequest(
    val phoneNumber: String,
    val address: String?,
    val detailAddress: String?
)

enum class GenderEnum {
    MALE, FEMALE
}