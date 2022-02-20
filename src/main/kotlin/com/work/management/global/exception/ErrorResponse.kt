package com.work.management.global.exception


data class ErrorResponse(
    val reason: String,
    val message: String? = null
) {
    companion object {
        fun of(reason: String, message: String?) = ErrorResponse(reason, message)
    }
}

private const val COMPONENT = "01"
const val REASON_SUCCESS = "000"

enum class ErrorReason(
    private val feature: String,
    private val reason: String
) {
    INVALID_INPUT_DATA("0001", "001"),
    USER_ALREADY_EXIST("0001", "003"),
    CREATE_GOAL_ALREADY_MAX_COUNT("0001", "003"),
    USER_STATUS_IS_NOT_ACTIVE("0001", "004")
    ;

    fun toReason() = "${COMPONENT}_${feature}_${reason}"
}