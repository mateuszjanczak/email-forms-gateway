package com.mateuszjanczak.efgs.repository

import com.mateuszjanczak.efgs.entity.EmailForm
import org.springframework.data.jpa.repository.JpaRepository

interface EmailFormRepository : JpaRepository<EmailForm, String> {
}