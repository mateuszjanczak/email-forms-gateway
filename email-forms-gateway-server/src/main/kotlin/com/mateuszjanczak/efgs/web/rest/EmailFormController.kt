package com.mateuszjanczak.efgs.web.rest

import com.mateuszjanczak.efgs.dto.CreatedEmailForm
import com.mateuszjanczak.efgs.dto.NewEmailForm
import com.mateuszjanczak.efgs.service.EmailFormService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmailFormController(private val emailFormService: EmailFormService) {

    @PostMapping(EmailFormEndpoints.FORM_NEW)
    fun handleForm(@RequestBody newEmailForm: NewEmailForm): CreatedEmailForm = emailFormService.saveEmailForm(newEmailForm)

}

object EmailFormEndpoints {
    const val FORM_NEW = "/api/form/new"
}