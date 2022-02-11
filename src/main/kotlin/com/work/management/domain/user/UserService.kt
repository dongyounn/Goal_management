package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.domain.user.dto.UpdateUserRequest
import com.work.management.global.exception.BadRequestException
import com.work.management.global.exception.ErrorReason
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun createUser(request: CreatUserRequest) {
        checkCreateUserIsExist(request.phoneNumber)
        validatePhoneNumber(request.phoneNumber)
        User.ofUserCreate(request).also {
            userRepository.save(it)
        }
    }

    @Transactional
    fun updateUser(userId: Long, request: UpdateUserRequest) {
        val user = checkUpdateUserIsExist(userId)
        user.updateUserInfo(request)
    }

    private fun validatePhoneNumber(phoneNumber: String) {
        phoneNumber.replace("-", "").replace(" ", "").let { formattedPhoneNumber ->
            formattedPhoneNumber.takeUnless { it.startsWith("0", false) }?.let {
                throw BadRequestException(
                    ErrorReason.INVALID_INPUT_DATA,
                    "전화번호는 0 으로 시작해야합니다. phoneNumber: $phoneNumber"
                )
            }
            formattedPhoneNumber.toCharArray().forEach {
                it.takeUnless { it.isDigit() }?.let {
                    throw BadRequestException(
                        ErrorReason.INVALID_INPUT_DATA,
                        "숫자만 입력가능합니다. phoneNumber: $phoneNumber"
                    )
                }
            }
        }
    }

    private fun checkCreateUserIsExist(phoneNumber: String) {
        userRepository.findByPhoneNumber(phoneNumber)?.let {
            throw BadRequestException(ErrorReason.USER_ALREADY_EXIST, "이미 존재하는 유저입니다. phoneNumber: $phoneNumber")
        }
    }

    private fun checkUpdateUserIsExist(userId: Long): User {
        return userRepository.findById(userId).get()
    }

    @Transactional(readOnly = true)
    fun findUserInfoById(phoneNumber: String): User {
        validatePhoneNumber(phoneNumber)
        return userRepository.findByPhoneNumber(phoneNumber)
            ?: throw BadRequestException(ErrorReason.USER_ALREADY_EXIST, "존재하지 않는 유저입니다. phoneNumber: $phoneNumber")
    }

    @Transactional
    fun deleteUser(userId: Long) {
        TODO("나중에 유저 삭제 할 떄 목표 진행중인거 있는지 확인 필요 ")
        userRepository.deleteById(userId)
    }


}