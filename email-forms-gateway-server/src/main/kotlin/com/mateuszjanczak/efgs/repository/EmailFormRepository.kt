package com.mateuszjanczak.efgs.repository

import com.mateuszjanczak.efgs.entity.EmailForm
import org.springframework.data.repository.CrudRepository

interface EmailFormRepository: CrudRepository<EmailForm, String> {
}