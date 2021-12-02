package com.exercise.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>


//https://www.data.go.kr/data/15012690/openapi.do