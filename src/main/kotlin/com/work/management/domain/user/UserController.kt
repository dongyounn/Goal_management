package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.domain.user.dto.UpdateUserRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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

    @PutMapping()
    fun updateUser(
        @Validated @RequestBody updateUserRequest: UpdateUserRequest
    ) {
        userService.updateUser(updateUserRequest)
    }
}