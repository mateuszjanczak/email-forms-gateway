package com.mateuszjanczak.efgs.service

import com.mateuszjanczak.efgs.dto.CreatedEmailForm
import com.mateuszjanczak.efgs.dto.NewEmailForm
import com.mateuszjanczak.efgs.dto.toEmailForm
import com.mateuszjanczak.efgs.entity.toCreatedEmailForm
import com.mateuszjanczak.efgs.repository.EmailFormRepository
import org.springframework.stereotype.Service

@Service
class EmailFormService(
    private val emailFormRepository: EmailFormRepository
) {
    fun saveEmailForm(newEmailForm: NewEmailForm): CreatedEmailForm {
        return emailFormRepository.save(newEmailForm.toEmailForm()).toCreatedEmailForm()
    }
}