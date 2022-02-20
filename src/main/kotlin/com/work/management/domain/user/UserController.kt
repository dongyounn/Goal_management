package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.domain.user.dto.UpdateUserRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping()
    fun createUser(
        @Validated @RequestBody createUserRequest: CreatUserRequest
    ) {
        userService.createUser(createUserRequest)
    }

    @PutMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: Long,
        @Validated @RequestBody updateUserRequest: UpdateUserRequest
    ) {
        userService.updateUser(userId,updateUserRequest)
    }

    @GetMapping
    fun getUserByPhoneNumber(
        @RequestParam phoneNumber: String
    ) = userService.findUserInfoById(phoneNumber)

    @DeleteMapping("{userId}")
    fun deleteUser(
        @PathVariable userId: Long
    ) {
        userService.deleteUser(userId)
    }
}