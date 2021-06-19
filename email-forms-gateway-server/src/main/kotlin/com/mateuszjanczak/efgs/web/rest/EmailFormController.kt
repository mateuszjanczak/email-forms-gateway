package com.mateuszjanczak.efgs.web.rest

import com.mateuszjanczak.efgs.dto.CreatedEmailForm
import com.mateuszjanczak.efgs.dto.NewEmailForm
import com.mateuszjanczak.efgs.service.EmailFormService
import com.mateuszjanczak.efgs.utils.getJsonFromRequest
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
class EmailFormController(private val emailFormService: EmailFormService) {

    @PostMapping(EmailFormEndpoints.FORMS)
    fun newForm(@RequestBody newEmailForm: NewEmailForm): CreatedEmailForm =
        emailFormService.saveEmailForm(newEmailForm)

    @GetMapping(EmailFormEndpoints.FORMS)
    fun listForm() = emailFormService.listEmailForm()

    @RequestMapping(EmailFormEndpoints.FORMS_ID)
    fun handleForm(@PathVariable id: String, request: HttpServletRequest) =
        emailFormService.handleEmailForm(id, getJsonFromRequest(request))

    @DeleteMapping(EmailFormEndpoints.FORMS_ID)
    fun removeForm(@PathVariable id: String) = emailFormService.removeEmailForm(id)
}

object EmailFormEndpoints {
    const val FORMS = "/api/forms"
    const val FORMS_ID = "/api/forms/{id}"
}