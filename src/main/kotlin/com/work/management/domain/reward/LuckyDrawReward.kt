package com.work.management.domain.reward

import com.work.management.global.dto.BaseDomain
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "lucky_draw_reward")
data class LuckyDrawReward(
    val generatedNumber: String,
    val generatedDate: String,
    val userId: Long,
    val expired: Boolean
) : BaseDomain() {
    @Id
    @GeneratedValue
    var id: Long? = null
}
