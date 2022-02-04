package com.work.management.domain.user

import com.work.management.domain.user.dto.CreatUserRequest
import com.work.management.domain.user.dto.GenderEnum
import com.work.management.global.exception.BadRequestException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate
import javax.transaction.Transactional

@SpringBootTest
@Transactional
internal class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    @DisplayName("유저 생성 테스트")
    fun creatUserTest() {
        val request = createUserRequest()

        Mockito.`when`(userRepository.findByPhoneNumber(request.phoneNumber)).thenReturn(null)

        userService.createUser(request)
    }

    @Test
    @DisplayName("유저 생성 실패 테스트")
    fun creatFailUserTest() {
        val request = createUserRequest()
        val existUser = User.ofUserCreate(request).apply { this.id = 1 }

        Mockito.`when`(userRepository.findByPhoneNumber(request.phoneNumber)).thenReturn(existUser)

        Assertions.assertThrows(BadRequestException::class.java) { userService.createUser(request) }

    }

    private fun createUserRequest() =
        CreatUserRequest("테스트", "01012341234", "test", "test", LocalDate.now(), GenderEnum.MALE)
}