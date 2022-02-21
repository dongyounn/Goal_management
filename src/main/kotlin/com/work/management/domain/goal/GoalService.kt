package com.work.management.domain.goal

import com.work.management.domain.user.UserRepository
import com.work.management.domain.user.UserStatusEnum
import com.work.management.global.dto.MAX_CREATE_GOAL
import com.work.management.global.exception.BadRequestException
import com.work.management.global.exception.ErrorReason
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoalService(
    private val goalRepository: GoalRepository,
    private val userRepository: UserRepository
) {

    @Transactional
    fun createGoal(request: GoalCreateRequest) {
        validationCreateGoal(request.userId)
        val createdGoal = goalRepository.save(Goal.of(request))
    }

    fun changeStatusActiveGoal(goalId: Long) {
        validationChangeable(goalId)
    }



    private fun checkUserValidation(userId: Long) {
        userRepository.findByIdOrNull(userId)?.let {
            if (it.status != UserStatusEnum.ACTIVE) {
                throw BadRequestException(
                    ErrorReason.USER_STATUS_IS_NOT_ACTIVE,
                    "유저 상태가 활성 상태가 아닙니다."
                )
            }
        } ?: throw BadRequestException(ErrorReason.INVALID_INPUT_DATA, "존재하지 않는 유저입니다. ")
    }


}