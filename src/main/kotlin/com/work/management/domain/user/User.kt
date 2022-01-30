package com.work.management.domain.user

import com.work.management.global.dto.BaseDomain
import com.work.management.global.dto.StringCryptoConverter
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    val name: String,
    @Convert(converter = StringCryptoConverter::class)
    val dayOfBirth: String,
    @Convert(converter = StringCryptoConverter::class)
    val phoneNumber: String,
    val userAddress: String,
    val userDetailAddress: String
) : BaseDomain() {
    @Id
    @GeneratedValue
    val id: Long? = null
}
