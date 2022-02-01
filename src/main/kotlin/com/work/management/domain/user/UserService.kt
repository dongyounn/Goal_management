package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.global.exception.BadRequestException
import com.work.management.global.exception.ErrorReason
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun createUser(request: CreatUserRequest) {
        checkUserIsExist(request.phoneNumber)
        User(
            request.name,
            request.dayOfBirth.toString(),
            request.phoneNumber,
            request.address,
            request.detailAddress,
            request.gender
        ).let {
            userRepository.save(it)
        }
    }

    private fun checkUserIsExist(phoneNumber: String) {
        userRepository.findByPhoneNumber(phoneNumber)?.let {
            throw BadRequestException(ErrorReason.USER_ALREADY_EXIST, "이미 존재하는 유저입니다. phoneNumber: $phoneNumber")
        }
    }
}