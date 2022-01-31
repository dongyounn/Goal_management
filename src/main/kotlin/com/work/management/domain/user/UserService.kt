package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun createUser(request: CreatUserRequest) {
        User(
            request.name,
            request.dayOfBirth.toString(),
            request.phoneNumber,
            request.address,
            request.detailAddress
        ).let {
            userRepository.save(it)
        }

    }
}