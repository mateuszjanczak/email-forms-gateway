package com.mateuszjanczak.efgs.dto

import com.mateuszjanczak.efgs.entity.EmailForm

data class CreatedEmailForm(
    val id: String,
    val formName: String,
    val forwardTo: String
)

fun CreatedEmailForm.toEmailForm() = EmailForm(
    formName = formName,
    forwardTo = forwardTo
)