package com.mateuszjanczak.efgs.dto

import com.mateuszjanczak.efgs.entity.EmailForm

data class NewEmailForm(
    val formName: String,
    val forwardTo: String
)

fun NewEmailForm.toEmailForm() = EmailForm(
    formName = formName,
    forwardTo = forwardTo
)