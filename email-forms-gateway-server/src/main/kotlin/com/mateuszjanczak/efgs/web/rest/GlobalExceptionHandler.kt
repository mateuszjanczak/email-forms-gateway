package com.mateuszjanczak.efgs.web.rest

import com.google.gson.stream.MalformedJsonException
import com.mateuszjanczak.efgs.dto.ErrorMessage
import com.mateuszjanczak.efgs.exception.EmailFormNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MalformedJsonException::class)
    fun handleMalformedJsonException(e: MalformedJsonException) = ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorMessage(message = "Malformed JSON", errorCode = HttpStatus.BAD_REQUEST.name))

    @ExceptionHandler(EmailFormNotFoundException::class)
    fun handleEmailFormNotFoundException(e: EmailFormNotFoundException) = ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorMessage(message = "Email form not found", errorCode = HttpStatus.NOT_FOUND.name))
}