package com.work.management.domain.goal

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GoalParticipantRepository : JpaRepository<GoalParticipants, Long>