package com.mateuszjanczak.efgs.utils

import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component

@Component
class EmailSender(private val javaMailSender: JavaMailSender) {

    fun sendEmail(to: String, subject: String, text: String) {
        val mimeMessage = javaMailSender.createMimeMessage()
        val mimeMessageHelper = MimeMessageHelper(mimeMessage, true)
        mimeMessageHelper.setTo(to)
        mimeMessageHelper.setSubject(subject)
        mimeMessageHelper.setText(text, true)
        javaMailSender.send(mimeMessage)
    }

}