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
    USER_ALREADY_EXIST("0001", "003")
    ;

    fun toReason() = "${COMPONENT}_${feature}_${reason}"
}