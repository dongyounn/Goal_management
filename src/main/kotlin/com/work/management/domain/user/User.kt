package com.work.management.domain.user

import com.work.management.domain.user.dto.GenderEnum
import com.work.management.global.dto.BaseDomain
import com.work.management.global.dto.StringCryptoConverter
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Convert(converter = StringCryptoConverter::class)
    val name: String,
    @Convert(converter = StringCryptoConverter::class)
    val dayOfBirth: String,
    @Convert(converter = StringCryptoConverter::class)
    val phoneNumber: String,
    val userAddress: String,
    val userDetailAddress: String,
    @Enumerated(EnumType.STRING)
    val gender: GenderEnum
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
}
