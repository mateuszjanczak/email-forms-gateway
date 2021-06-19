package com.mateuszjanczak.efgs.service

import com.mateuszjanczak.efgs.dto.CreatedEmailForm
import com.mateuszjanczak.efgs.dto.NewEmailForm
import com.mateuszjanczak.efgs.dto.toEmailForm
import com.mateuszjanczak.efgs.entity.EmailForm
import com.mateuszjanczak.efgs.entity.toCreatedEmailForm
import com.mateuszjanczak.efgs.exception.EmailFormNotFoundException
import com.mateuszjanczak.efgs.repository.EmailFormRepository
import com.mateuszjanczak.efgs.utils.EmailSender
import com.mateuszjanczak.efgs.utils.getMapFromJson
import org.springframework.stereotype.Service

@Service
class EmailFormService(
    private val emailFormRepository: EmailFormRepository,
    private val emailSender: EmailSender
) {
    fun saveEmailForm(newEmailForm: NewEmailForm): CreatedEmailForm =
        emailFormRepository.save(newEmailForm.toEmailForm()).toCreatedEmailForm()

    fun listEmailForm(): Collection<EmailForm> = emailFormRepository.findAll()

    fun handleEmailForm(id: String, json: String) {
        with(emailFormRepository) {
            findById(id)
                .map {
                    emailSender.sendEmail(
                        to = it.forwardTo,
                        subject = "New message from ${it.formName}",
                        text = getMapFromJson(json).toString()
                    )
                }
                .orElseThrow(::EmailFormNotFoundException)
        }
    }

    fun removeEmailForm(id: String) = emailFormRepository.deleteById(id)
}