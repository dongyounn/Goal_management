package com.work.management.domain.reward

import com.work.management.global.dto.BaseDomain
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "lucky_draw_reward")
data class LuckyDrawReward(
    val generatedNumber: String,
    val generatedDate: LocalDateTime,
    val userId: Long,
    val expired: Boolean
) : BaseDomain() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    companion object {
        fun ofSetting(generatedNumber: String, userId: Long) = LuckyDrawReward(
            generatedNumber,
            LocalDateTime.now(),
            userId,
            false
        )
    }
}
