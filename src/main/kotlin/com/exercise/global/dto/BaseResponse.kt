package com.exercise.global.dto

data class BaseResponse(
    val reason: String,
    val message: Any? = null
) {
    companion object {
        fun ofSuccess(obj: Any) = BaseResponse("SUCCESS", obj)

        fun ofSuccessMessage() = BaseResponse("SUCCESS", null)
    }
}