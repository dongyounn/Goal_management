package com.exercise.domain.affiliation

import com.exercise.global.dto.BaseDomain
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "affiliation")
data class Affiliation(
    val name: String,
    val address: String,
    val detailAddress: String

) : BaseDomain() {
    @Id
    val id: Long? = null
}