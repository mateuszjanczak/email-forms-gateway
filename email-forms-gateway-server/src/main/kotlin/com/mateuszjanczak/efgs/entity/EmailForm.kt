package com.mateuszjanczak.efgs.entity

import com.mateuszjanczak.efgs.dto.CreatedEmailForm
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class EmailForm(
    @Id @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = "",
    val formName: String,
    val forwardTo: String
)

fun EmailForm.toCreatedEmailForm() = CreatedEmailForm(
    id = id,
    formName = formName,
    forwardTo = forwardTo
)