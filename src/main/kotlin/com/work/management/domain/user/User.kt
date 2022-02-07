package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.domain.user.dto.GenderEnum
import com.work.management.domain.user.dto.UpdateUserRequest
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
    var userAddress: String,
    var userDetailAddress: String,
    @Enumerated(EnumType.STRING)
    val gender: GenderEnum,
    @Enumerated(EnumType.STRING)
    val status: UserStatusEnum
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    companion object {
        fun ofUserCreate(request: CreatUserRequest): User {
            return User(
                request.name,
                request.dayOfBirth.toString(),
                request.phoneNumber,
                request.address,
                request.detailAddress,
                request.gender,
                UserStatusEnum.ACTIVE
            )
        }
    }

    fun updateUserInfo(request: UpdateUserRequest) {
        this.userAddress = request.address ?: this.userAddress
        this.userDetailAddress = request.detailAddress ?: this.userDetailAddress
    }
}

enum class UserStatusEnum {
    ACTIVE, SUSPENDED, TERMINATED
}
