package com.exercise.domain.user

import com.exercise.global.dto.BaseDomain
import com.exercise.global.dto.StringCryptoConverter
import com.sun.org.apache.xpath.internal.operations.Bool
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "exercise_user")
data class User(
    @Id
    val id: Long? = null,
    @Convert(converter = StringCryptoConverter::class)
    val name: String,
    @Convert(converter = StringCryptoConverter::class)
    val phoneNumber: String,
    @Convert(converter = StringCryptoConverter::class)
    val dayOfBirth: String,
    @Enumerated(EnumType.STRING)
    val status: UserStatusEnum,
    val lastDayOfLogin: LocalDateTime
) : BaseDomain()

enum class UserStatusEnum(val status: Boolean) {
    ACTIVE(true), TERMINATED(false), DORMANT(false)
}
