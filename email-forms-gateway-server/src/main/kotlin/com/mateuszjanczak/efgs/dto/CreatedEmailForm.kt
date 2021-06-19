package com.mateuszjanczak.efgs.dto

data class CreatedEmailForm(
    val id: String,
    val formName: String,
    val forwardTo: String
)